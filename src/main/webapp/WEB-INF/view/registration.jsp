<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">

    <title>Create an account</title>

</head>

<body>

<div class="container">

    <form:form method="POST" modelAttribute="userForm" class="form-signin">
        <h2 class="form-signing-heading">Create your account</h2>
        <spring:bind path="fullName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="fullName" class="form-control" placeholder="Username" autofocus="true"/>
                <form:errors path="fullName"/>
            </div>
        </spring:bind>

        <spring:bind path="username">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="username" class="form-control" placeholder="User Login" autofocus="true"/>
                <form:errors path="username"/>
            </div>
        </spring:bind>

        <spring:bind path="userPassword">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="userPassword" path="userPassword" class="form-control" placeholder="User Password"/>
                <form:errors path="userPassword"/>
            </div>
        </spring:bind>

        <spring:bind path="userPasswordConfirm">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="userPasswordConfirm" path="userPasswordConfirm" class="form-control"
                            placeholder="Comfirm your password"/>
                <form:errors path="userPasswordConfirm"/>
            </div>
        </spring:bind>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>

</div>
</body>
</html>