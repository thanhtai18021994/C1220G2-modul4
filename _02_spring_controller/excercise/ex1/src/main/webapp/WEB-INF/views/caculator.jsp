<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/28/2021
  Time: 3:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/tinhtoan" method="post">
<lable> Nhap so dau tien:<input type="number" name="num1"></lable>
<label>Nhap so thu hai: <input type="number" name="num2"></label>
    <input type="submit" value="phepcong" name="pheptinh">
    <input type="submit" value="pheptru" name="pheptinh">
    <input type="submit" value="phepnhan" name="pheptinh">
    <input type="submit" value="phepchia" name="pheptinh">
</form>
<h3>${result}</h3>
</body>
</html>
