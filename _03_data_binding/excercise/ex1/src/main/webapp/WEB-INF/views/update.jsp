<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/29/2021
  Time: 11:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="mailBox" type=""--%>
<form:form action="/update" modelAttribute="mailBox" method="get">
    <table>
        <tr>
            <td>Language</td>
            <td><form:select path="language" items="${listCountry}"></form:select></td>
        </tr>
        <tr>
            <td>Page size</td>
            <td><lable>Show <form:select path="pageSize" items="${listSize}"></form:select> email each page</lable></td>
        </tr>
        <tr>
            <td>Spam filler</td>
            <td><form:checkbox path="spamFiller"/> Enable spam filler</td>
        </tr>
        <tr>
            <td>sigNature</td>
            <td><form:textarea path="sigNature" cols="20" rows="5"></form:textarea></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="update">
                <input type="button" value="cancle">
            </td>
        </tr>
    </table>
</form:form>
<p>Ban co muon pupdate khong ?</p><a href="/updateAgian">Yes</a>
</body>
</html>
