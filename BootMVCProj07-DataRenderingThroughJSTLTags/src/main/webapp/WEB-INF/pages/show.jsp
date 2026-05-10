<%@ page isELIgnored="false" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
  <c:when test="${!empty empData}">
   <table border="1" bgcolor="cyan" align="center">
     <tr><th>eno</th><th>ename</th><th>salary</th></tr>
      <c:forEach var="emp" items="${empData}">
      <tr>
       <td>${emp.id}</td>
       <td>${emp.name}</td>
       <td>${emp.salary}</td>
      
      </tr>
      
      </c:forEach>
   
   </table>
  
  </c:when>
  <c:otherwise>
    <h1 style= "color:red; text-align: center">Employee not found</h1>
  </c:otherwise>
</c:choose>

