<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 22/09/2019
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1> Strona Logowania</h1>
<form action="/bimber/login"
      method="post">
    user:
    <input type="text" name="user"><br>
    password:
    <input type="text" name="password"><br>
    <input type="submit" name="LOG IN">

</form>
</body>
</html>
