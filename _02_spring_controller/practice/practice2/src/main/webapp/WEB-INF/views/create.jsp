<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/28/2021
  Time: 1:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Them moi hoc sinh</h3>
<form action="/create" method="post">
    <lable>Nhap id: <input type="text" name="id"></lable><br>
    <lable>Nhap Ten: <input type="text" name="name"></lable><br>
    <lable>Nhap dia chi:<input type="text" name="address"></lable><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
