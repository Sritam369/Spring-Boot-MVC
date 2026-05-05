<%@ page isELIgnored="false"%>
<%@ page import = "java.util.List" %>
<%@ page import = "com.sri.model.Product"%>

<h1 style="color:red;text-align:center">Welcome To Home Page</h1>
<h2>Products List</h2>
<p>------------------</p>
<% 
List<Product> list = (List<Product>)request.getAttribute("product");%>
<%
for(Product p:list){
	out.println(p+"<br>");
}
%>