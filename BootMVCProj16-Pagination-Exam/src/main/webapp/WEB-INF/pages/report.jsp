<%@ page isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
<c:when test="${!empty msg.getContent() }">
<table>
<tr>
<th>
Id
</th>
<th>
Name
</th>
<th>
Price
</th>
<th colspan="2">
Operations
</th>
</tr>

<c:forEach var="o" items="${msg.getContent()}">
<tr>
<td>${o.id }</td>
<td>${o.name }</td>
<td>${o.price }</td>
<td><a href="edit?no=${o.id}">Edit</a></td>
<td><a href="delete?no=${o.id}">Delete</a></td>
</tr>
</c:forEach>
</table>

<p >
<c:if test="${!msg.isFirst()}"><a href="report?page=0">First</a>&nbsp;&nbsp;</c:if>
<c:if test="${!msg.isLast()}"><a href="report?page=${msg.getPageable().getPageNumber()+1 }">Next</a>&nbsp;&nbsp;</c:if>
<c:forEach var="i" begin="1" end="${msg.getTotalPages()}" step="1">
<a href="report?page=${i-1}">${i}</a>&nbsp;&nbsp;
</c:forEach>
<c:if test="${!msg.isFirst()}"><a href="report?page=${msg.getPageable().getPageNumber()-1}">Previous</a>&nbsp;&nbsp;</c:if>
<c:if test="${!msg.isLast()}"><a href="report?page=${msg.getTotalPages()-1}">Last</a>&nbsp;&nbsp;</c:if>
</p>

</c:when>

<c:otherwise>Record not found</c:otherwise>
</c:choose>

<h2>${add}</h2>
<h2>${update}</h2>
<h2>${delete}</h2>
<h2><a href="add">Add Orders</a></h2>
