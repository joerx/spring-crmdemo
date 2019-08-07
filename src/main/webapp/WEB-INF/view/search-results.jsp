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
            <h2>Search Results</h2>

            <jsp:include page="fragments/customer-list.jsp"/>

        </div>
    </div>
</main>

<jsp:include page="fragments/scripts.jsp"/>

</body>
</html>
