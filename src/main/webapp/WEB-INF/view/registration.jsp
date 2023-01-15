<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Create an account</title>
    <link href="${contextPath}/resources/css/style-registration.css" rel="stylesheet">
</head>

<body>

<div class="container-name">
    <h2 class="form-heading">Log in</h2>
</div>

<form:form method="POST" modelAttribute="userForm" class="form-signin">
    <spring:bind path="fullName">
        <div>
            <form:input type="text" path="fullName" placeholder="Username" autofocus="true"/>
            <form:errors path="fullName"/>
        </div>
    </spring:bind>

    <spring:bind path="username">
        <div>
            <form:input type="text" path="username" placeholder="User Login"/>
            <form:errors path="username"/>
        </div>
    </spring:bind>

    <spring:bind path="userPassword">
        <div>
            <form:input type="password" path="userPassword" placeholder="User Password"/>
            <form:errors path="userPassword"/>
        </div>
    </spring:bind>

    <spring:bind path="userPasswordConfirm">
        <div>
            <form:input type="password" path="userPasswordConfirm" placeholder="Comfirm your password"/>
            <form:errors path="userPasswordConfirm"/>
        </div>
    </spring:bind>
    <button type="submit">Submit</button>
    <p><a class="back-to-login" href="<c:url value="/login"/>">Back to Login</a></p>
</form:form>

</body>
</html>