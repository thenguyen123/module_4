<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2/2/2023
  Time: 11:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Settings</h1>
<form:form modelAttribute="newEmail" action="/setting" method="post">
<form:hidden path="id" value="${newEmail.id}"></form:hidden>
  <p>languages</p>
  <form:select path="languages">
    <form:options items="${arrayLanguages}"></form:options>
  </form:select>
  <p>Size</p>
  <form:select path="size">
    <form:options items="${arraySize}"></form:options>
  </form:select>
  <p>Spams filter</p>
  <form:checkbox  path="spamsFilter" value="false"></form:checkbox>Yes
  <form:checkbox path="spamsFilter" value="true"></form:checkbox>No
  <p>Signature</p>
  <form:textarea  path="signature" ></form:textarea>
  <form:button>Update</form:button>
</form:form>
</body>
</html>
