<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/28/2021
  Time: 11:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>$Title$</title>
    <link rel="stylesheet" href="bootstrap-4.6.0-dist/css/bootstrap.css">
  </head>
  <body>
  <div class="container">
    <table class="table table-hover">
      <thead>
      <tr>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Email</th>
        <th colspan="2">Action</th>
      </tr>
      </thead>
      <tbody>
     <c:forEach var="student" items="${listStudent}">
       <tr>
         <td>${student.id}</td>
         <td>${student.name}</td>
         <td>${student.address}</td>
         <td><a href="/delete?id=${student.id}">Xoa</a></td>
         <td><a href="#">Sua</a></td>
       </tr>
     </c:forEach>
      </tbody>
    </table>
    <a href="/create">Them moi</a>
  </div>
  <script src="bootstrap-4.6.0-dist/js/bootstrap.js"></script>
  </body>
</html>
