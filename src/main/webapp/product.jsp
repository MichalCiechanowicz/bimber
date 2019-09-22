<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 22/09/2019
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
</head>
<body>
<form action="/bimber/product"
      method="post">
    Id<br>
    <input type="text" name="id"><br>
    Rodzaj<br>
    <input type="text" name="rodzaj"><br>
    nazwa<br>
    <input type="text" name="nazwa"><br>
    moc<br>
    <input type="text" name="moc"><br>
    region<br>
    <input type="text" name="region"><br>
    price<br>
    <input type="text" name="price"><br>

    <input type="submit" name="add">
</form>
</body>
</html>
