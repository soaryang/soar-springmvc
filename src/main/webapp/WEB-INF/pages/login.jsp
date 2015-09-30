<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 15/9/6
  Time: 下午4:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        登陆界面
    </title>
    <script src="/js/jquery-1.11.0.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            var object = {
                'channelId':'1'
            };
            $("#myButton").click(function () {
                $.ajax({
                    type: "POST",
                    url: 'http://192.168.211.172:8081/actvchannelshows/list2?jsoncallback=?',
                    data: object,
                    async: false,
                    contentType: "application/json",
                    dataType: 'json',
                    error: function (data) {
                        //alert(request);
                        //alert(xhr.statusText + "\r\n" + xhr.responseText);
                        //console.log(data);
                        alert("error---------->"+data)
                    },
                    success: function (data) {
                        //$("#commonLayout_appcreshi").parent().html(data);
                        alert("success---------->"+data)
                    }
                });
            });
        });
        function jsoncallback(data) //回调函数
        {
            alert(data.code); //
        }
    </script>
</head>
<body>
<form action="/checklogin">
    <input type="text" id="username" name="username"/>
    <input type="password" id="password" name="password"/>
    <input type="text" id="userType" name="userType"/>
    <button type="submit" value="submit">提交</button>
</form>

<div id=“first”>

    <div>showlist</div>
    <div>
        <a href="http://localhost:8081/actvchannelshows/list/1">showlist</a>
    </div>
</div>

<div id="insert">
    <form name="mainForm" >
        <div>
            频道编号:<input type="text" id="channelId" name="channelId" value="1">
        </div>
        <table>
            <tr>
                <td>
                    节目编号
                </td>
                <td>
                    节目序号
                </td>
                <td>
                    节目名称
                </td>
                <td>
                    节目url
                </td>
                <td>
                    删除状态
                </td>
                <td>
                    更新状态
                </td>
                <td>
                    插入状态
                </td>

            </tr>
            <tr>
                <td>
                    <input type="text" id="id_1" name="id_1">
                </td>
                <td>
                    <input type="text" id="sortId_1" name="sortId_1">
                </td>
                <td>
                    <input type="text" id="showName_1" name="showName_1" value="5555555555">
                </td>
                <td>
                    <input type="text" id="showUrl_1" name="showUrl_1" value="555555555555">
                </td>
                <td>
                    <input type="text" id="deleteFlg_1" name="deleteFlg_1" value="0">
                </td>
                <td>
                    <input type="text" id="updateFlg_1" name="updateFlg_1" value="0">
                </td>
                <td>
                    <input type="text" id="insertFlg_1" name="insertFlg_1" value="1">
                </td>
            </tr>
        </table>
        <input type="button" id="myButton" value="提交"/>
    </form>
</div>

</body>
</html>
