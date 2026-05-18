<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>

<frm:form action="submit" modelAttribute="emp">
Employee Name : <frm:input path="empName"/><br>
Employee Desg : <frm:input path="job"/><br>
Employee Salary : <frm:input path="sal"/><br>
Employee DeptNo : <frm:input path="deptNo"/><br>
<button>Submit</button>
</frm:form>
