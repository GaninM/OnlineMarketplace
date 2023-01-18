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

<h2 class="products">All products</h2>
<table>
    <tr>
        <th scope="col">Title</th>
        <th scope="col">Description</th>
        <th scope="col">Price</th>
        <th scope="col">Start date</th>
        <th scope="col">End date</th>
        <th scope="col">Bid Inc</th>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td class="description"><c:out value="${product.description}"/></td>
            <td><c:out value="${product.startPrice}"/></td>
            <td><c:out value="${product.startDate}"/></td>
            <td><c:out value="${product.endDate}"/></td>
            <td><c:out value="${product.bidInc}"/></td>
            <td><a href="${contextPath}/product-info/${product.id}">More</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a class="create-product" href="<c:url value="/product-create"/>">Create product</a>
</body>
</html>