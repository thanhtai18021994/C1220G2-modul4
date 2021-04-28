<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/28/2021
  Time: 3:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h3>Danh sach gia vi cho sandwich</h3>
  <form action="/giavi">
    <lable>Mắm <input type="checkbox" name="gv" value="Mam"></lable><br>
    <lable>Muối <input type="checkbox" name="gv" value="Muoi"></lable><br>
    <lable>Ớt <input type="checkbox" name="gv" value="Ot"></lable><br>
    <lable>Tiêu <input type="checkbox" name="gv" value="Tieu"></lable><br>
    <lable>Bột nêm <input type="checkbox" name="gv" value="Bot nem"></lable><br>
    <input type="submit" value="submit">
    <c:forEach var="giavi" items="${danhsach}">
      <p>${giavi}</p>
    </c:forEach>
  </form>
  </body>
</html>
