<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: amank
  Date: 12/27/2023
  Time: 3:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Employees</title>
</head>
<body>
    <h3>Employee List</h3>
    <br>
    <br>

    <security:authorize access="hasRole('MANAGER')">
        <input type="button" value="Salary" onclick="window.location.href = 'manager-page'">
        <p>Only for Manager staff</p>
    </security:authorize>

    <security:authorize access="hasRole('ADMIN')">
        <input type="button" value="Performance" onclick="window.location.href = 'admin-page'">
        <p>Only for Admin staff</p>
    </security:authorize>

</body>
</html>
