<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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

            <h2>${title}</h2>

            <p><a href="${pageContext.request.contextPath}">Back</a></p>

            <form:form action="${pageContext.request.contextPath}/customer/${action}" modelAttribute="customer" method="post">

                <form:hidden path="id"/>

                <%-- first name --%>
                <div class="form-group">
                    <spring:bind path="firstName">


                        <label for="firstName">First Name</label>
                        <input
                                name="firstName"
                                id="firstName"
                                class="form-control ${status.error ? "is-invalid" : ""}"
                                value="${customer.firstName}"
                                placeholder="John"
                        />

                        <c:if test="${status.error}">
                            <span class="invalid-feedback">${status.errorMessage}</span>
                        </c:if>
                    </spring:bind>
                </div>

                <%-- last name --%>
                <div class="form-group">
                    <spring:bind path="lastName">
                        <label for="lastName">Last Name</label>
                        <input
                                name="lastName"
                                id="lastName"
                                class="form-control ${status.error ? "is-invalid" : ""}"
                                value="${customer.lastName}"
                                placeholder="Doe"
                        />

                        <c:if test="${status.error}">
                            <span class="invalid-feedback">${status.errorMessage}</span>
                        </c:if>
                    </spring:bind>
                </div>

                <%-- email --%>
                <div class="form-group">
                    <spring:bind path="email">
                        <label for="email">Email</label>
                        <input
                                name="email"
                                id="email"
                                class="form-control ${status.error ? "is-invalid" : ""}"
                                value="${customer.email}"
                                placeholder="e.g. john.doe@example.org"
                        />

                        <c:if test="${status.error}">
                            <span class="invalid-feedback">${status.errorMessage}</span>
                        </c:if>
                    </spring:bind>
                </div>

                <%-- submit thingy--%>
                <button type="submit" class="btn btn-primary">Submit</button>

            </form:form>

        </div>
    </div>
</main>

<jsp:include page="fragments/scripts.jsp"/>

</body>
</html>
