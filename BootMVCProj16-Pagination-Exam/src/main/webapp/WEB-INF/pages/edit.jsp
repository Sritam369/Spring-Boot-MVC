<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>

<frm:form action="update" modelAttribute="order">
Order Id : <frm:input path="id" readonly="true"/>
Order name : <frm:input path="name"/>
Order price : <frm:input path="price"/>
<button>Edit</button>
</frm:form>
