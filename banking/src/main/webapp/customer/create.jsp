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
            <h1 style="text-align: center">customer information</h1>
            <p>
                <c:if test='${requestScope["message"] != null}'>
                    <span>${requestScope["message"]}</span>
                </c:if>
            </p>
            <p>
                <a href="/customers">back list customer</a>
            </p>
            <form method="post">
                <div class="mb-3">
                    <label for="name" class="form-label">name</label>
                    <input class="form-control" name="fullName" id="name" aria-describedby="emailHelp">

                </div>

                <div class="mb-3">
                    <label for="phone" class="form-label">Phone</label>
                    <input class="form-control" name="phoneNumber" id="phone" aria-describedby="emailHelp">

                </div>

                <div class="mb-3">
                    <label for="email" class="form-label">email</label>
                    <input class="form-control" name="email" id="email" aria-describedby="emailHelp">
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
</body>
</html>
