<%@ page isELIgnored="false"%>

<h1>Register for courses</h1>
<br><br>

<form action="submit" method="post">
Enter course id : <input type="text" name= "courseId">
<p>Select courses</p>
<input type="checkbox" name="courseName" value="java"> Java <br>
<input type="checkbox" name="courseName" value = "springboot"> SpringBoot<br>
<input type="checkbox" name="courseName" value="python"> Python<br>
<input type="checkbox" name="courseName" value="datascience"> Data Science<br>
<button>Submit</button>
</form>