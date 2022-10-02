<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Welcome</title>
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet">
</head>
<body>

<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <div class="container-name">
            <h2>Welcome ${pageContext.request.userPrincipal.name}</h2>
            <h2>Welcome ${pageContext.}</h2>
        </div>
        <div class="logout-text" onclick="document.forms['logoutForm'].submit()">Logout</div>
        <h4><a href="${contextPath}/products">Look all items</a></h4>
    </c:if>
    <p><a class="create-product" href="<c:url value="/product-create"/>">Create product</a></p>
    <h2 class="your-lots">Your lots</h2>
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
        <c:forEach var="product" items="${myProducts}">
            <tr>
                <td><c:out value="${product.id}"/></td>
                <td><c:out value="${product.ownerId}"/></td>
                <td><c:out value="${product.offerId}"/></td>
                <td style="white-space: nowrap"><c:out value="${product.title}"/></td>
                <td><c:out value="${product.description}"/></td>
                <td><c:out value="${product.startPrice}"/></td>
                <td style="white-space: nowrap"><c:out value="${product.startDate}"/></td>
                <td style="white-space: nowrap"><c:out value="${product.endDate}"/></td>
                <td><c:out value="${product.bidInc}"/></td>
            </tr>
        </c:forEach>
    </table>

</div>
</body>
</html>