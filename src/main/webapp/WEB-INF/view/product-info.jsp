<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Product information</title>
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet">
</head>
<body>
<form id="logoutForm" method="POST" action="${contextPath}/logout">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
<div class="container-name">
    <h2>Product information</h2>
</div>
<div class="logout-text" onclick="document.forms['logoutForm'].submit()">Logout</div>
<table>
    <tr>
        <th scope="col">Title</th>
        <th scope="col">Description</th>
        <th scope="col">Price</th>
        <th scope="col">Start date</th>
        <th scope="col">End date</th>
        <th scope="col">Bid Inc</th>
        <th scope="col">New bid</th>
    </tr>
    <tr>
        <td><c:out value="${modelProduct.title}"/></td>
        <td><c:out value="${modelProduct.description}"/></td>
        <td><c:out value="${modelProduct.startPrice}"/></td>
        <td><c:out value="${modelProduct.startDate}"/></td>
        <td><c:out value="${modelProduct.endDate}"/></td>
        <td><c:out value="${modelProduct.bidInc}"/></td>
    </tr>
</table>
<br>
<form:form method="POST" modelAttribute="modelBid">
<spring:bind path="bidPrice">
<div class="form-group ${status.error ? 'has-error' : ''}">
        <form:input cssClass="bid-field-input" type="integer" path="bidPrice" placeholder="Bid price"/>
        <form:errors path="bidPrice"/>
    </spring:bind>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>
</body>
</html>