<%--
  Created by IntelliJ IDEA.
  User: HOANG CHUONG
  Date: 9/23/2021
  Time: 10:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <%@include file="header.jsp" %>
</head>
<body>
    <div class="container">
        <h1 style="text-align: center">management customer</h1>
        <h2 style="text-align: center">
            <a href="${pageContext.request.contextPath}/customers?action=create">create customer</a>
        </h2>
        <table class="table">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>NAME</th>
                    <th>PHONE</th>
                    <th>EMAIL</th>
                    <th>BALANCE</th>
                    <th></th>
                    <th></th>
                    <th>ACTION</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                    <c:forEach items = "${customerList}" var = "customer">

                        <tr>
                                <td><c:out value="${customer.id}"/></td>
                                <td><c:out value="${customer.fullName}"/></td>
                                <td><c:out value="${customer.phoneNumber}"/></td>
                                <td><c:out value="${customer.email}"/></td>
                                <td><c:out value="${customer.balance}"/></td>
                                <td>
                                    <button type="button" class="btn btn-outline-secondary">
                                        <a style="text-decoration: none" href="${pageContext.request.contextPath}/customers?action=edit&id=${customer.id}">EDIT</a>
                                    </button>
                                </td>
                                <td>
                                    <button type="button" class="btn btn-outline-success">
                                        <a style="text-decoration: none" href="${pageContext.request.contextPath}/customers?action=send&id=${customer.id}">SEND MONEY</a>
                                    </button>
                                </td>
                                <td>
                                    <button type="button" class="btn btn-outline-danger">
                                        <a style="text-decoration: none" href="${pageContext.request.contextPath}/customers?action=withdraw&id=${customer.id}">WITHDRAW</a>
                                    </button>
                                </td>
                                <td>
                                    <button type="button" class="btn btn-outline-info">
                                        <a style="text-decoration: none" href="${pageContext.request.contextPath}/customers?action=transfer&id=${customer.id}">TRANSFER</a>
                                    </button>
                                </td>
                                <td>
                                    <button type="button" class="btn btn-outline-primary">
                                        <a style="text-decoration: none" href="${pageContext.request.contextPath}/customers?action=remove&id=${customer.id}">EDIT</a>
                                    </button>
                                </td>
                        </tr>
                    </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
