<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="sp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

<h1 style="color:red;text-align:center"><sp:message code="cust.registration.title" /></h1>
<br><br>
<frm:form modelAttribute="cust">
<table>
<tr>
<td><sp:message code="cust.registration.name" /></td>
<td><frm:input path="cname"/></td>
</tr>
<tr>
<td><sp:message code="cust.registration.addrs" /></td>
<td><frm:input path="caddrs"/></td>
</tr>
<tr>
<td><sp:message code="cust.registration.billAmt" /></td>
<td><frm:input path="billAmt"/></td>
</tr>
<tr>
<td><input type="submit" value="<sp:message code="cust.btn.register"/>"/></td>
</tr>
</table>
</frm:form>