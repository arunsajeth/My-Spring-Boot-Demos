<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
 <%@ page import="com.example.demo.entity.Employee" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 10px;
        }

        th, td {
            padding: 10px;
            text-align: center;
         }

        th {
            background-color: #333;
            color: #fff;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #ddd;
        }
</style>

</head>
<body>

<%@ include file="menu.jsp" %><br><br>

<h2>VIEW EMPLOYEE PAGE</h2><br>

<table ">
<thead>
<tr>
	<th colspan="1">ID</th>
	<th colspan="1">Name</th>
	<th colspan="1">Salary</th>
	<th colspan="1">Department</th>
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