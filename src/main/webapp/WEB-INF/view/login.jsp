<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Log in with your account</title>
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet">
</head>

<body class="loginBody">
<form method="POST" action="${contextPath}/login" class="form-signin">
    <div class="container-name">
        <h2 class="form-heading">Log in</h2>
    </div>

    <div class="form-group ${error != null ? 'has-error' : ''}">

        <label for="username"><b>Username<br></b></label>
        <input name="username" id="username" type="text" class="form-control" placeholder="Enter Username"
               autofocus="autofocus"/>

        <br>

        <label for="userPassword"><b>Password<br></b></label>
        <input name="userPassword" id="userPassword" type="text" class="form-control" placeholder="Enter Password"/>

        <span>${error}</span>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <br>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
        <br>
        <button class="create-account" type="button"><a class="registration-link" href="${contextPath}/registration">Create
            an account</a></button>
    </div>

</form>

</div>

</body>
</html>