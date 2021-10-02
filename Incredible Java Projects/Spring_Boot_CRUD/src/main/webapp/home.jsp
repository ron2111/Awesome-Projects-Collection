<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>Add Student</p>
	<p title="Add Student"></p>
	<form action="addStudent">
		<label>Enter ID</label>
		<input type="text" name="id"><br>
		<label>Enter Name</label>
		<input type="text" name="name"><br>
		<label>Enter Technology</label>
		<input type="text" name="tech"><br>
		<input type="submit"><br>
	</form>
	<p>Fetch Student by ID</p>
	<form action="getStudent">
		<label>Enter ID</label>
		<input type="text" name="id"><br>
		<input type="submit"><br>
	</form>
	<p>Update Student Details</p>
	<form action="updateStudent">
		<label>Enter ID</label>
		<input type="text" name="id"><br>
		<label>Enter Name</label>
		<input type="text" name="name"><br>
		<label>Enter Technology</label>
		<input type="text" name="tech"><br>
		<input type="submit"><br>
	</form>
	<p>Delete Student</p>
	<form action="deleteStudent">
	<label>Enter ID</label>
		<input type="text" name="id"><br>
		<input type="submit"><br>
	</form>
	
	



</body>
</html>