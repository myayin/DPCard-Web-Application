
<%--
  Created by IntelliJ IDEA.
  User: Merve
  Date: 21.12.2019
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Login page</title>
    <link th:href="@{/public/style.css}" rel="stylesheet" />
</head>
<body>
<div id="container">
    <h2>Login page</h2>
    <form th:action="@{/login}" method="post">
        <label for="username">Username</label>
        <input type="text" id="username" name="username" autofocus="autofocus" />
        <label for="password">Password</label>
        <input type="password" id="password" name="password" />
        <input id="submit" type="submit" value="Log in" />
    </form>
    <p th:if="${loginError}" class="error">Wrong user or password</p>
</div>
</body>
</html>
