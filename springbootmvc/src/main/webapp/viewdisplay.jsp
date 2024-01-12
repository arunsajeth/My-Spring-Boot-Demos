<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.List" %>
 <%@ page import="com.example.demo.model.Employee" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<thead>
<tr>
	<th>ID</th>
	<th>Name</th>
	<th>Salary</th>
	<th>Department</th>
</tr>
</thead>
<tbody>
	<% 
		List<Employee> list = (List<Employee>) request.getAttribute("list");
		for(Employee d : list)
		{
	%>
		<tr>
		<td><%= d.getEid() %></td>
		<td><%= d.getEname() %></td>
		<td><%= d.getSalary() %></td>
		<td><%= d.getDept() %></td>
		</tr>
	<% } %>
</tbody>
</table>
</body>
</html>