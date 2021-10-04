<%--
  Created by IntelliJ IDEA.
  User: HOANG CHUONG
  Date: 10/1/2021
  Time: 9:43 AM
  To change this template use File | Settings | File Templates.
--%>
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
    <%@include file="/product/header.jsp" %>
</head>
<body>
<div class="container">
    <h1 style="text-align: center">management product</h1>
    <h2 style="text-align: center">
        <a href="${pageContext.request.contextPath}/Product?action=create">create product</a>
    </h2>
    <table class="table">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>price</th>
            <th>quantity</th>
            <th>color</th>
            <th>description</th>
            <th>category</th>
            <th>ACTION</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items = "${products}" var = "product">

            <tr>
                <td><c:out value="${product.id}"/></td>
                <td><c:out value="${product.name}"/></td>
                <td><c:out value="${product.price}"/></td>
                <td><c:out value="${product.quantity}"/></td>
                <td><c:out value="${product.color}"/></td>
                <td><c:out value="${product.description }"/></td>
                <td><c:out value="${product.categoryId}"/></td>
                <td></td>


                <td>
                    <button type="button" class="btn btn-outline-secondary">
                        <a style="text-decoration: none" href="${pageContext.request.contextPath}/Product?action=edit&id=${product.id}">EDIT</a>
                    </button>
                </td>


                <td>
                    <button type="button" class="btn btn-outline-primary">
                        <a style="text-decoration: none" href="${pageContext.request.contextPath}/Product?action=remove&id=${product.id}">REMOVE</a>
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>

