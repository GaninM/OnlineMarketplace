<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>All products</title>
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet">
</head>

<body>
<form id="logoutForm" method="POST" action="${contextPath}/logout">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
<div class="logout-text" onclick="document.forms['logoutForm'].submit()">Logout</div>

<h2>All users</h2>
<table>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Name</th>
        <th scope="col">Username</th>
        <th scope="col">User Password</th>
    </tr>
    <c:forEach var="user" items="${adminUsers}">
        <tr>
            <td><c:out value="${user.id}"/></td>
            <td><c:out value="${user.fullName}"/></td>
            <td><c:out value="${user.username}"/></td>
            <td><c:out value="${user.userPassword}"/></td>
            <td><a href="${contextPath}/admin/user-update/${user.id}">Edit</a></td>
            <td><a href="${contextPath}/admin/user-delete/${user.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>