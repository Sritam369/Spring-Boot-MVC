<%@ page isELIgnored="false"%>
<%@ page import="java.util.Arrays" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>Result page</h1><br><br>


<h2>Course Enrolled : <br> 
<c:forEach var="name" items="${courses}">
- ${name} <br>

</c:forEach>
</h2>
<h2>Total Fee : ${total}</h2>