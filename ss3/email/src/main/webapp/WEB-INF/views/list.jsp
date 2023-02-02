<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2/2/2023
  Time: 10:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>List Email</h1>
<p>${mess}</p>
<table>
    <tr>
        <th>STT</th>
        <th>Languages</th>
        <th> Page Size</th>
        <th> Spams Filter</th>
        <th> Signature</th>
        <th>Settings</th>
    </tr>
    <c:forEach items="${list}" varStatus="c" var="email">
        <tr>
        <td>${c.count}</td>
        <td>${email.languages}</td>
        <td>${email.size}</td>
        <td>${email.spamsFilter}</td>
        <td>${email.signature}</td>
        <td>
            <button><a href="/setting?id=${email.id}">setting</a></button>
        </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
