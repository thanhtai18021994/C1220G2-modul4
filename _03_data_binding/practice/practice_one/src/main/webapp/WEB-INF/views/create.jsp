<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/28/2021
  Time: 9:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Tao nhan vien moi</h3>
<form:form action="/create" method="get" modelAttribute="employee">
    <lable>Nhap id: <form:input type="text"  path="id"/></lable>
    <lable>Nhap ten: <form:input type="text"  path="name"/></lable>
    <lable>Nhap so dien thoai: <form:input type="text"  path="phone"/></lable>
    <button type="submit">Xac Nhan</button>
</form:form>
</body>
</html>
