<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/28/2021
  Time: 2:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/checkEmail" method="post">
 <lable>Nhap email: <input type="text" name="email"></lable>
  <input type="submit" value="submit">
</form>
<p>${notify}</p>
</body>
</html>
