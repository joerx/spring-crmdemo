<nav class="navbar navbar-dark" style="background-color: #007bff;">
    <a class="navbar-brand" href="#">CRM Demo</a>
    <ul class="navbar-nav mr-auto">
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/customer/list">Customers</a>
        </li>
    </ul>
    <form class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/search/results">
        <input class="form-control mr-sm-2" type="search" placeholder="Search" name="q" value="${searchQuery}"/>
        <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Search</button>
    </form>
</nav>
