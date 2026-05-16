<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
<c:when test="${!empty result }">
<table>
<tr>
<th>Order id</th>
<th>Customer name</th>
<th>Item name</th>
<th>Quantity</th>
<th>Price</th>
<th>TotalAmt</th>
<th colspan="2">Operations</th>
</tr>
<c:forEach var="food" items="${result}">
<tr>
<td>${food.orderId }</td>
<td>${food.custName }</td>
<td>${food.itemName }</td>
<td>${food.quantity }</td>
<td>${food.price }</td>
<td>${food.totalAmt }</td>
<td><a href="edit_order?no=${food.orderId }">Edit</a></td>
<td><a href="delete_order?no=${food.orderId }">Delete</a></td>
</tr>
</c:forEach>
</table>
</c:when>

<c:otherwise>No order found</c:otherwise>
</c:choose>
<h2>${insert}</h2>
<h2>${update}</h2>
<h2>${delete}</h2>
<h2><a href="add">Add order</a></h2>
