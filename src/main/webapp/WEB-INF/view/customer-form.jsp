<jsp:useBean id="title" scope="request" type="java.lang.String"/>
<jsp:useBean id="customer" scope="request" type="io.yodo.crmdemo.entity.Customer"/>

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

            <form:form action="create" modelAttribute="customer" method="post">

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
