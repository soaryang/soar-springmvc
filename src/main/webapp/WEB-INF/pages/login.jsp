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
</head>
<body>
    <form action="/checklogin">
        <input type="text" id="username" name="username"/>
        <input type="password" id="password" name="password" />
        <button type="submit" value="submit">提交</button>
    </form>
</body>
</html>
