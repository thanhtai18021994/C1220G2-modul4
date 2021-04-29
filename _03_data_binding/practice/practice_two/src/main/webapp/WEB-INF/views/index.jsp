
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/28/2021
  Time: 10:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h3>Home</h3>
<form:form action="/login" method="post" modelAttribute="login">
<fieldset>
  <table>
    <tr>
      <td>Password</td>
      <td><form:input path="name"></form:input></td>
    </tr>
    <tr>
      <td>Password</td>
      <td><form:input path="password"></form:input></td>
    </tr>
    <tr>
      <td></td>
      <td><input type="submit" value="xacnhan"></td>
    </tr>
  </table>
</fieldset>
</form:form>
  </body>
</html>
