<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Merve
  Date: 20.12.2019
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Employees</title>
    <link href="http://localhost:8080/webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
    <script src="http://localhost:8080/webjars/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
    <script src="http://localhost:8080/webjars/jquery/3.0.0/js/jquery.min.js" ></script>
</head>
<body>
<div class="container">
    <spring:url value="/user/test" var="saveURL" />
    <h2>Employee</h2>
    <form:form modelAttribute="employeeForm" method="get" action="${saveURL }" cssClass="form">

        <div class="form-group">
            <lable for="EmolyeeName">First Name</lable>
            <form:input path="employeeName" cssClass="form-control" id="EmolyeeName" />
        </div>
        <div class="form-group">
            <lable for="EmployeeSurname">Last Name</lable>
            <form:input path="employeeSurname" cssClass="form-control" id="EmployeeSurname" />
        </div>
        <div class="form-group">
            <lable for="EmployeeEmail">Email</lable>
            <form:input path="employeeEmail" cssClass="form-control" id="EmployeeEmail" />
        </div>
        <div class="form-group">
            <lable for="employeePasword">Phone</lable>
            <form:input path="employeePassword" cssClass="form-control" id="employeePasword" />
        </div>
        <div class="form-group">
            <lable for="EmployeePhone">Phone</lable>
            <form:input path="employeePhone" cssClass="form-control" id="EmployeePhone" />
        </div>

        <button type="submit" class="btn btn-primary">Save</button>
    </form:form>
</div>
</body>
</html>
