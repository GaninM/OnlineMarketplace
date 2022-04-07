<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>All products</title>
</head>

<body>
<h2>Items</h2>
<table border="2" width="70%" cellpadding="2">
    <tr>
        <th>Id</th>
        <th>Title</th>
        <th>Description</th>
        <th>Price</th>
        <th>Start date</th>
        <th>End date</th>
        <th>Bid Inc</th>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td><c:out value="${product.id}"/></td>
            <td><c:out value="${product.title}"/></td>
            <td><c:out value="${product.description}"/></td>
            <td><c:out value="${product.startPrice}"/></td>
            <td><c:out value="${product.startDate}"/></td>
            <td><c:out value="${product.endDate}"/></td>
            <td><c:out value="${product.bidInc}"/></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="/product-create">Create product</a>
</body>
</html>