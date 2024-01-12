<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>REGISTRATION PAGE</h2>
<form action="AddEmployee">
<div>
	<label>Employee Id: </label><br>
	<input type="text" name="eid" value="" placeholder="Enter the id"><br>
	<label>Employee Name: </label><br>
	<input type="text" name="ename" value="" placeholder="Enter the name"><br>
	<label>Employee Salary: </label><br>
	<input type="text" name="salary" value="" placeholder="Enter the salary"><br>
	<label>Employee Dept: </label><br>
	<input type="text" name="dept" value="" placeholder="Enter the department"><br>
</div>
<br>
<input type="submit" value="ADD">
<input type="reset" value="CLEAR">
</form>
<br><br>
<form action="view">
	<input type="submit" value="VIEW">
</form>
</body>
</html>