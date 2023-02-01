<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2/1/2023
  Time: 11:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<h1>Caculator</h1>
<form method="post" action="result">
<input type="number" name="numberOne">
<input type="number" name="numberTwo">

<button class="btn btn-outline-success" type="submit" name="caculator" value="Addition">Addition(+)</button>
<button class="btn btn-outline-success" type="submit"  name="caculator" value="Subtraction">Subtraction(-)</button>
<button class="btn btn-outline-success" type="submit"  name="caculator" value="Multiplication">Multiplication(X)</button>
<button class="btn btn-outline-success" type="submit"  name="caculator" value="Division" >Division(:)</button>
</form>
<p>Result ${mess} ${result}</p>
</body>
</html>
