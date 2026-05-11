<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>

<h1 style="color:red;text-align:center">Student Registration Page</h1>
<br><br>

<frm:form action="register" method="POST" modelAttribute="stud">

<table border="1" align="center" bgcolor="cyan">
<tr>
<td>Student id : </td>
<td><frm:input type="text" path="sno"/></td>
</tr>
<tr>
<td>Student name : </td>
<td><frm:input type="text" path="sname"/></td>
</tr>
<tr>
<td>Student address : </td>
<td><frm:input type="text" path="sadd"/></td>
</tr>
<tr>
<td>Student average : </td>
<td><frm:input type="text" path="avg"/></td>
</tr>
<tr>
<td colspan="2"> <input type="submit" value="Register"></td>
<td colspan="2"> <input type="submit" value="Cancels"></td>
</tr>

</table>


</frm:form>