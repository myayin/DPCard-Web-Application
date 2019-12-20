<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Merve
  Date: 20.12.2019
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Employee List</title>
    <link href="../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
    <script src="../webjars/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
    <script src="../webjars/jquery/3.0.0/js/jquery.min.js" ></script>
</head>
<body>
<div class="container">
    <h2>Employee List</h2>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="row">Employee Id</th>
            <th scope="row">First Name</th>
            <th scope="row">Last Name</th>
            <th scope="row">Email</th>
            <th scope="row">Phone</th>
            <th scope="row">Job Title</th>
            <th scope="row">Edit</th>
            <th scope="row">Delete</th>
        </tr>

    </table>
    <spring:url value="/employee/add" var="addURL" />
    <a class="btn btn-primary" href="${addURL }" role="button">Add New Employee</a>
</div>
</body>
</html>
