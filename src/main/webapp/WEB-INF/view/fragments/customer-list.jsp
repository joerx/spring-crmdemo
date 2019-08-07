<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table">
    <thead>
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>&nbsp;</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${customers}" var="customer">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.firstName}</td>
            <td>${customer.lastName}</td>
            <td>${customer.email}</td>
            <td>
                <a href="${pageContext.request.contextPath}/customer/edit/${customer.id}">
                    Edit
                </a>&nbsp;
                <a href="${pageContext.request.contextPath}/customer/delete/${customer.id}"
                   onclick="if (!confirm('Are you sure you want to do this?')) return false">
                    Delete
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
