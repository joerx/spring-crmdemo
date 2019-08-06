<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--@elvariable id="flashInfo" type="java.lang.String"--%>
<%--@elvariable id="flashErr" type="java.lang.String"--%>

<c:if test="${not empty flashInfo}">
    <div class="alert alert-info" role="alert">
        ${flashInfo}
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
</c:if>

<c:if test="${not empty flashErr}">
    <div class="alert alert-danger" role="alert">
        ${flashErr}
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
</c:if>
