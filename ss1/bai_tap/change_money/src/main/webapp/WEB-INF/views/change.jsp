<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 1/31/2023
  Time: 11:06 AM
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
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Exchange</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Features</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Pricing</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled">Disabled</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
</body>
<form action=" " method="post">
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Enter USD</label>
        <input type="number" class="form-control" id="exampleInputEmail1" name="money" aria-describedby="emailHelp" required>
    </div>
    <div class="mb-3">
        <label class="form-label">Enter Exchange Rate</label>
        <input type="number" class="form-control" name="rate" aria-describedby="emailHelp" required>
    </div>
    <div class="mb-3"><p>USA </p>
        <p>${result}</p>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>


</html>
