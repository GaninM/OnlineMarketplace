<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Admin</title>
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet">
</head>

<body>
<div class="logout-text" onclick="document.forms['logoutForm'].submit()">Logout</div>
<div>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h2>Admin Page ${pageContext.request.userPrincipal.name}</h2>
    </c:if>
</div>
<p><a class="look-all-items" href="<c:url value="/admin/products"/>">Look all products</a></p>
<br>
<p><a class="look-all-items" href="<c:url value="/admin/users"/>">Look all users</a></p>
</body>
</html>