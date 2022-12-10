<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create product</title>
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet">
</head>

<body>
<h1>Create Product</h1>
<form:form method="POST" modelAttribute="productForm">
    <table>
        <tr>
            <th scope="col">Title</th>
            <th scope="col">Description</th>
            <th scope="col">Start price</th>
            <th scope="col">Start date</th>
            <th scope="col">End date</th>
            <th scope="col">Bid inc</th>
        </tr>
        <td><spring:bind path="title">
            <form:input cssClass="text-field-input" type="text" path="title" placeholder="Product title" autofocus="true"/>
        </spring:bind></td>

        <td><spring:bind path="description">
            <form:input cssClass="text-field-input" type="text" path="description" placeholder="Description"/>
        </spring:bind></td>

        <td><spring:bind path="startPrice">
            <form:input cssClass="text-field-input" type="text" path="startPrice" placeholder="Price"/>
        </spring:bind></td>

        <td><spring:bind path="startDate">
            <form:input cssClass="text-field-input" type="date" path="startDate" placeholder="Start date"/>
        </spring:bind></td>

        <td><spring:bind path="endDate">
            <form:input cssClass="text-field-input" type="date" path="endDate" placeholder="End date"/>
        </spring:bind></td>

        <td><spring:bind path="bidInc">
            <form:input cssClass="text-field-input" type="text" path="bidInc" placeholder="Bid Inc"/>
        </spring:bind></td>
    </table>
    <br>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
</form:form>
</body>
</html>