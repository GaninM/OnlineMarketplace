<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create product</title>
    <link href="${contextPath}/resources/css/style-product-create.css" rel="stylesheet">
</head>

<body>
<form id="logoutForm" method="POST" action="${contextPath}/logout">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>

<div class="logout-text" onclick="document.forms['logoutForm'].submit()">Logout</div>
<div>
    <h2 class="header">Create Product</h2>
</div>
<br>
<p><a class="look-all-items" href="<c:url value="/products"/>">Back to all products</a></p>
<br>
<form:form method="POST" modelAttribute="productForm">
    <label for="title"><b>Title<br></b></label>
    <spring:bind path="title">
        <div>
            <form:input cssClass="text-field-input" type="text" path="title" placeholder="Product title"
                        autofocus="true"/>
            <form:errors path="title"/>
        </div>
    </spring:bind>

    <label for="description"><b>Description<br></b></label>
    <spring:bind path="description">
        <div>
            <form:input cssClass="text-field-input" type="text" path="description" placeholder="Description"/>
            <form:errors path="description"/>
        </div>
    </spring:bind>

    <label for="startPrice"><b>Start Price<br></b></label>
    <spring:bind path="startPrice">
        <div>
            <form:input cssClass="text-field-input" type="text" path="startPrice" placeholder="Price"/>
            <form:errors path="startPrice"/>
        </div>
    </spring:bind>

    <label for="startDate"><b>Start Date<br></b></label>
    <spring:bind path="startDate">
        <div class="start-date">
            <form:input cssClass="text-field-input" type="date" path="startDate" placeholder="Start date"/>
            <form:errors path="startDate"/>
        </div>
    </spring:bind>

    <label for="endDate"><b>End Date<br></b></label>
    <spring:bind path="endDate">
        <div class="end-date">
            <form:input cssClass="text-field-input" type="date" path="endDate" placeholder="End date"/>
            <form:errors path="endDate"/>
        </div>
    </spring:bind>

    <label for="bidInc"><b>Bid Increment<br></b></label>
    <spring:bind path="bidInc">
        <div>
            <form:input cssClass="text-field-input" type="text" path="bidInc" placeholder="Bid Inc"/>
            <form:errors path="bidInc"/>
        </div>
    </spring:bind>
    <br>
    <button class="submit-button" type="submit">Submit</button>
</form:form>
</body>
</html>