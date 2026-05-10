<%@ page isELIgnored="false"%>

<h1 style="color:red;text-align:center">Student Registration Page</h1>
<br><br>

<form action="register" method="POST">
<table align="center" bgcolor="cyan">
<tr>
 <td>Student number</td>
 <td><input type="text" name="sno"></td>
</tr>
<tr>
 <td>Student name</td>
 <td><input type="text" name="sname"></td>
</tr>
<tr>
 <td>Student address</td>
 <td><input type="text" name="sadd"></td>
</tr>
<tr>
 <td>Student avg</td>
 <td><input type="text" name="avg"></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="Register"></td>
</tr>

</table>

</form>
