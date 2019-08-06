<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html>
<head>
    <jsp:include page="fragments/header.jsp" />
    <title>Customer List</title>
</head>
<body>
<jsp:include page="fragments/navbar.jsp" />

<main class="container-fluid" id="main">
    <div class="row">
        <div class="col">
            <h2>Customers</h2>

            <jsp:include page="fragments/flash.jsp"/>

            <p>
                <a class="btn btn-light" href="${pageContext.request.contextPath}/customer/new">
                    Add Customer
                </a>
            </p>

            <table class="table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${customers}" var="customer">
                    <tr>
                        <td>${customer.id}</td>
                        <td>${customer.firstName}</td>
                        <td>${customer.lastName}</td>
                        <td>${customer.email}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>
</main>

<jsp:include page="fragments/scripts.jsp"/>

</body>
</html>
