<%--
  Created by IntelliJ IDEA.
  User: HOANG CHUONG
  Date: 9/24/2021
  Time: 3:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>create customer</title>
    <%@include file="header.jsp" %>
</head>
<body>
<div class="container">
    <h1 style="text-align: center">edit customer</h1>
    <p>
        <a href="${pageContext.request.contextPath}/customers">back list customer</a>
    </p>
    <p>
    <p>
        <c:if test='${requestScope["message"] != null}'>
            <span>${requestScope["message"]}</span>
        </c:if>
    </p>
    </p>
    <p>

    </p>
    <form method="post">
        <div class="mb-3">
            <label for="name" class="form-label">name</label>
            <input value="<c:out value="${customer.fullName}"/>" class="form-control" name="fullName" id="name" />

        </div>

        <div class="mb-3">
            <label for="phone" class="form-label">Phone</label>
            <input value="<c:out value="${customer.phoneNumber}"/>" class="form-control" name="phoneNumber" id="phone" />

        </div>

        <div class="mb-3">
            <label for="email" class="form-label">email</label>
            <input value="<c:out value="${customer.email}"/>" class="form-control" name="email" id="email" />
        </div>

        <div class="mb-3">
            <label for="balance" class="form-label">balance</label>
            <input value="<c:out value="${customer.balance}"/>" class="form-control" name="balance" id="balance" />
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>

