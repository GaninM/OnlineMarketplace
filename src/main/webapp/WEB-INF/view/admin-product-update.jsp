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

<form:form action="#" modelAttribute="product" method="post">
    <label for="id"><b>Id<br></b></label>
    <div>
        <form:input cssClass="text-field-input" type="text" path="id" value="${product.id}"/>
    </div>

    <label for="ownerId"><b>Owner Id<br></b></label>
    <div>
        <form:input cssClass="text-field-input" type="text" path="ownerId" value="${product.ownerId}"/>
    </div>

    <label for="offerId"><b>Offer Id<br></b></label>
    <div>
        <form:input cssClass="text-field-input" type="text" path="offerId" value="${product.offerId}"/>
    </div>

    <label for="title"><b>Title<br></b></label>
    <div>
        <form:input cssClass="text-field-input" type="text" path="title" value="${product.title}"/>
    </div>

    <label for="description"><b>Description<br></b></label>
    <div>
        <form:input cssClass="text-field-input" type="text" path="description" value="${product.description}"/>
    </div>

    <label for="startPrice"><b>Price<br></b></label>
    <div>
        <form:input cssClass="text-field-input" type="text" path="startPrice" value="${product.startPrice}"/>
    </div>

    <label for="startDate"><b>Start Date<br></b></label>
    <div class="start-date">
        <form:input cssClass="text-field-input" type="date" path="startDate" value="${product.startDate}"/>
    </div>

    <label for="endDate"><b>End Date<br></b></label>
    <div class="end-date">
        <form:input cssClass="text-field-input" type="date" path="endDate" value="${product.endDate}"/>
    </div>

    <label for="bidInc"><b>Bid Increment<br></b></label>
    <div>
        <form:input cssClass="text-field-input" type="text" path="bidInc" value="${product.bidInc}"/>
    </div>
    <br>
    <form:button class="submit-button" type="submit">Submit</form:button>
</form:form>
</body>
</html>