<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2/1/2023
  Time: 4:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Welcome</h1>
<form:form method="post" action="/addEmployee" modelAttribute="employee">
  <table>
    <tr>
      <td><form:label path="id" >ID</form:label></td>
      <td><form:input path="id"></form:input></td>
    </tr>
     <tr>
      <td><form:label path="name" >name</form:label></td>
      <td><form:input path="name"></form:input></td>
    </tr>
     <tr>
      <td><form:label path="contactNumber" >contactNumber</form:label></td>
      <td><form:input path="contactNumber"></form:input></td>
    </tr>
    <tr>
      <td><input type="submit" value="Submit"></td>
    </tr>

  </table>
</form:form>
</body>
</html>
