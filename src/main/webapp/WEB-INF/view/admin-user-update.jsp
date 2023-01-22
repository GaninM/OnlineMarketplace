<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Product update</title>
    <link href="${contextPath}/resources/css/style-product-create.css" rel="stylesheet">
</head>
<body>
<form id="logoutForm" method="POST" action="${contextPath}/logout">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
<div class="logout-text" onclick="document.forms['logoutForm'].submit()">Logout</div>

<div class="container-name">
    <h2>Product update</h2>
    <p><a class="look-all-items" href="<c:url value="/admin/products"/>">Back to all products</a></p>
</div>

<form:form action="#" modelAttribute="user" method="post">
    <label for="id"><b>Id<br></b></label>
    <div>
        <form:input cssClass="text-field-input" type="text" path="id" value="${user.id}"/>
    </div>

    <label for="fullName"><b>Name<br></b></label>
    <div>
        <form:input cssClass="text-field-input" type="text" path="fullName" value="${user.fullName}"/>
    </div>

    <label for="username"><b>Username<br></b></label>
    <div>
        <form:input cssClass="text-field-input" type="text" path="username" value="${user.username}"/>
    </div>

    <label for="userPassword"><b>Password<br></b></label>
    <div>
        <form:input cssClass="text-field-input" type="text" path="userPassword" value="${user.userPassword}"/>
    </div>
    <br>
    <form:button class="submit-button" type="submit">Submit</form:button>
</form:form>
</body>
</html>