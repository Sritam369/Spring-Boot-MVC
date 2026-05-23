<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>

<frm:form action="added" modelAttribute="order">
Order name : <frm:input path="name"/>
Order price : <frm:input path="price"/>
<button>Add</button>
</frm:form>
