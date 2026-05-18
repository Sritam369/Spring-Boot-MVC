<%@ page isELIgnored="false"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<c:choose>
<c:when test="${!empty result.getContent()}">
<h1 style="color:green;text-align:center">Employees Report</h1>
<table border="1" align="center" bgcolor="cyan">
<tr>
<th>Employee Id</th>
<th>Employee Name</th>
<th>Employee Job</th>
<th>Employee Salary</th>
<th>Employee Dept No.</th>
<th colspan="2">Employee Operations</th>
</tr>
<c:forEach var="emp" items="${result.getContent()}">
<tr>
<td>${emp.empNo}</td>
<td>${emp.empName}</td>
<td>${emp.job}</td>
<td>${emp.sal}</td>
<td>${emp.deptNo}</td>
<td><a href="emp_edit?no=${emp.empNo}">Edit</a></td>
<td><a href="emp_delete?no=${emp.empNo}" onclick="return confirm('Do you want to delete this employee record ?')">Delete</a></td>

</tr>
</c:forEach>
</table>

<p style="text-align:center">
<c:if test="${!result.isFirst()}"><a href="report?page=0">First</a>&nbsp;&nbsp;</c:if>
<c:if test="${!result.isLast()}"><a href="report?page=${result.getPageable().getPageNumber()+1 }">Next</a>&nbsp;&nbsp;</c:if>
<c:forEach var="i" begin="1" end="${result.getTotalPages()}" step="1">
<a href="report?page=${i-1}">${i}</a>&nbsp;&nbsp;
</c:forEach>
<c:if test="${!result.isFirst()}"><a href="report?page=${result.getPageable().getPageNumber()-1}">Previous</a>&nbsp;&nbsp;</c:if>
<c:if test="${!result.isLast()}"><a href="report?page=${result.getTotalPages()-1}">Last</a>&nbsp;&nbsp;</c:if>
</p>

</c:when>
<c:otherwise><h1 style="color:green;text-align:center">Employees Not Available</h1></c:otherwise>
</c:choose>

<h1 style="color:green;text-align:center">${resultMsg}</h1>
<h1 style="color:green;text-align:center">${updateMsg}</h1>
<h1 style="color:green;text-align:center">${deleteMsg}</h1>

<h2 style="color:green;text-align:center"><a href="add">Add Employee Record</a></h2>
