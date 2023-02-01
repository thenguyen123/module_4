<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2/1/2023
  Time: 10:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form method="post" action="choose" >
    <input name="sandwich" type="checkbox" value="lettuce">Lettuce
    <input name="sandwich" type="checkbox" value="tomato">Tomato
    <input name="sandwich" type="checkbox" value="mustard">Mustard
    <input name="sandwich" type="checkbox" value="sprout">Sprouts
    <button type="submit">Save</button>
</form>
Your Choose:
<c:forEach var="sd" items="${sandwich}">
    <p>${sd}</p>
</c:forEach>
</body>
</html>
