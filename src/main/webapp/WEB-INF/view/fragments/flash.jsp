<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--@elvariable id="flashMsg" type="java.lang.String"--%>

<c:if test="${not empty flashMsg}">
    <div class="alert alert-info" role="alert">
            ${flashMsg}

        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
</c:if>
