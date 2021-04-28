<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/27/2021
  Time: 8:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Helllo ${myName}</h1>
<form action="/a" method="post">
    <lable>VND:<input type="number" name="vnd"></lable>
    <lable>USD:<input type="text" value="${money}"></lable>
    <input type="submit" value="Submit">
</form>
</body>
</html>
