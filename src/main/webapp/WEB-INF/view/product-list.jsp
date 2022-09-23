<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>All products</title>
    <link href="${contextPath}/resources/css/style-product-list.css" rel="stylesheet">
</head>

<body>
<form id="logoutForm" method="POST" action="${contextPath}/logout">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
<div class="logout-text" onclick="document.forms['logoutForm'].submit()">Logout</div>

<h2 class="products">Items</h2>
<table>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Owner id</th>
        <th scope="col">Offer id</th>
        <th scope="col">Title</th>
        <th scope="col">Description</th>
        <th scope="col">Price</th>
        <th scope="col">Start date</th>
        <th scope="col">End date</th>
        <th scope="col">Bid Inc</th>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td><c:out value="${product.id}"/></td>
            <td><c:out value="${product.ownerId}"/></td>
            <td><c:out value="${product.offerId}"/></td>
            <td><c:out value="${product.title}"/></td>
            <td><c:out value="${product.description}"/></td>
            <td><c:out value="${product.startPrice}"/></td>
            <td><c:out value="${product.startDate}"/></td>
            <td><c:out value="${product.endDate}"/></td>
            <td><c:out value="${product.bidInc}"/></td>
            <td><a href="${contextPath}/product-update/${product.id}">Update</a></td>
            <td><a href="${contextPath}/product-delete/${product.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a class="create-product" href="<c:url value="/product-create"/>">Create product</a>
</body>
</html>