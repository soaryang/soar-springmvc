<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" ng-app="todoApp">
<head>
    <script src="/js/jquery-1.11.0.min.js" type="text/javascript"></script>
    <script src="/js/angular.min.js" type="text/javascript"></script>
    <link href="/css/bootstrap.css" rel="stylesheet"/>
    <link href="/css/bootstrap-theme.css" rel="stylesheet"/>
</head>
<!--控制器-->
<body ng-controller="ToDoCtrl">
<div class="page-header">
    <h1>
        {{todo.user}}'s To Do List
        <span class="label label-default">条数：{{todo.items.length}}</span>
        <!--ng-hide判断是否隐藏-->

        <span class="label label-default" ng-hide="incompleteCount()==0" ng-class="warningLevel()">
                未选中的条数：{{incompleteCount()}}
        </span>
    </h1>
</div>
<div class="panel">
    <div class="input-group">
        <input class="form-control" ng-model="actionText"/>
        <span class="input-group-btn">
            <button class="btn btn-default"
                    ng-click="addNewItem(actionText)">Add
            </button>
        </span>
    </div>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>Description</th>
            <th>Done</th>
        </tr>
        </thead>
        <tbody>
        <!--添加了过滤 和 排序-->
        <tr ng-repeat="item in todo.items | checkedItems:showComplete | orderBy:'action'">
            <td>{{item.action}}</td>
            <td><input type="checkbox" ng-model="item.done"/></td>
            <td>{{item.done}}</td>
        </tr>
        <!--
        <tr ng-repeat="item in todo.items | filter:{done: false} | orderBy:'action'">
            <td>{{item.action}}</td>
            <td><input type="checkbox" ng-model="item.done"/></td>
            <td>{{item.done}}</td>
        </tr>
        -->
        </tbody>
    </table>
    <div class="checkbox-inline">
        <label><input type="checkbox" ng_model="showComplete"> Show Complete</label>
    </div>

    <table>
        <tr>
            <td>验证码</td>
            <td><input id="index_code" name="code" type="text"/></td>
            <td>
                <img id="imgObj" alt="验证码" src="/getCode"/>
                <a href="#" onclick="changeImg()">换一张</a>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
<script type="text/javascript" language="JavaScript">

    function changeImg() {
        var imgSrc = $("#imgObj");
        var src = imgSrc.attr("src");
        imgSrc.attr("src", chgUrl(src));
    }
    //时间戳
    //为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳
    function chgUrl(url) {
        var timestamp = (new Date()).valueOf();
        url = url.substring(0, 17);
        if ((url.indexOf("&") >= 0)) {
            url = url + "×tamp=" + timestamp;
        } else {
            url = url + "?timestamp=" + timestamp;
        }
        return url;
    }


    //创建模型
    var todoApp = angular.module("todoApp", []);
    //模型数据结构
    var model = {
        user: "Adam"
        /*,items: [{action: "Buy Flowers", done: false},
         {action: "Get Shoes", done: false},
         {action: "Collect Tickets", done: true},
         {action: "Collect Tickets", done: true},
         {action: "Call Joe", done: false}]*/
    };

    //自定义一个过滤器
    todoApp.filter("checkedItems", function () {
        return function (items, showComplete) {
            var resultArr = [];
            angular.forEach(items, function (item) {
                if (item.done == false || showComplete == true) {
                    resultArr.push(item);
                }
            });
            return resultArr;
        }
    });


    /*
     todoApp.run(function ($http) {
     $http.get("/json.html").success(function (data) {
     alert(data)
     });
     });
     */
    //控制器
    todoApp.controller("ToDoCtrl", function ($http, $scope) {
        $http.get("/json.html").success(function (data) {
            //alert(data[0])
            model.items = data;
        });
        $scope.todo = model;

        //自定义函数获取未选中的条数
        $scope.incompleteCount = function () {
            var count = 0;
            angular.forEach($scope.todo.items, function (item) {
                if (!item.done) {
                    count++
                }
            });
            return count;
        }

        //新的处理函数，如果伟未选择的小于3个发生警号
        $scope.warningLevel = function () {
            return $scope.incompleteCount() < 3 ? "label-success" : "label-warning";
        }

        //增加一个添加动作的行为
        $scope.addNewItem = function (actionText) {
            $scope.todo.items.push({action: actionText, done: false});
            //actionText 是这个控制器作用范围的一个属性
            $scope.actionText = "ok";
        }
    });

</script>