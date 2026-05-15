<%@ page isELIgnored="false"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<c:choose>
<c:when test="${!empty result}">
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
<c:forEach var="emp" items="${result}">
<tr>
<td>${emp.empNo}</td>
<td>${emp.empName}</td>
<td>${emp.job}</td>
<td>${emp.sal}</td>
<td>${emp.deptNo}</td>
<td><a href="emp_edit?no=${emp.empNo}">Edit</a></td>
<td><a href="emp_delete?no=${emp.empNo}">Delete</a></td>

</tr>
</c:forEach>


</table>
</c:when>
<c:otherwise><h1 style="color:green;text-align:center">Employees Not Available</h1></c:otherwise>
</c:choose>
<h1 style="color:green;text-align:center">${resultMsg}</h1>
<h1 style="color:green;text-align:center">${updateMsg}</h1>
<h1 style="color:green;text-align:center">${deleteMsg}</h1>

<h2 style="color:green;text-align:center"><a href="add">Add Employee Record</a></h2>
