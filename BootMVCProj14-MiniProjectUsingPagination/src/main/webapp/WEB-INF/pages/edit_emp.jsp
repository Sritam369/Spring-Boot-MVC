<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>

<frm:form action="edit" modelAttribute="emp">
Employee id : <frm:input path="empNo" readonly="true"/><br>
Employee name : <frm:input path="empName" /><br>
Employee desg : <frm:input path="job" /><br>
Employee salary : <frm:input path="sal" /><br>
Employee dept no. : <frm:input path="deptNo"/><br>
<input type="submit" value="Edit">
</frm:form>