<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>

<frm:form action="insert" modelAttribute="food">
Customer name : <frm:input path="custName"/><br>
Item name : <frm:input path="itemName"/><br>
Quantity : <frm:input path="quantity"/><br>
Price : <frm:input path="price"/><br>
<frm:button>Add</frm:button>
</frm:form>
