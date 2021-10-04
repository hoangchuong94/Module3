<%--
  Created by IntelliJ IDEA.
  User: HOANG CHUONG
  Date: 9/22/2021
  Time: 9:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>admin</title>
    <%@include file="/layout/layout.jsp"%>
</head>
<body>
<h1 style="text-align: center">management employee</h1>
<p>
    <a href="/admin?action=create">Create New Customer</a>
</p>
<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">First Name</th>
        <th scope="col">Last Name</th>
        <th scope="col">Birth Day</th>
        <th scope="col">Gender</th>
        <th scope="col">Salary</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listEmployee}" var="item">
        <tr>
            <td><c:out value="${item.id}"/></td>
            <td><c:out value="${item.firstName}"/></td>
            <td><c:out value="${item.lastName}"/></td>
            <td><c:out value="${item.birthDay}"/></td>
            <td><c:out value="${item.sex}"/></td>
            <td><c:out value="${item.salary}"/></td>
            <td></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
