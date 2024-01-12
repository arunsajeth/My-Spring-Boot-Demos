<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file = "menu.jsp" %>
<br><br>
<form action="empsearch">
<input type="radio" name="oper" value="Search By Name">By Name<br>
<input type="radio" name="oper" value="Search By Salary">By Salary<br>
<input type="radio" name="oper" value="Search By Departments">By Departments<br>

<br><br>
<input type="search" name="data" value="" ><br>
<input type="submit" value="SUBMIT">


</form>
</body>
</html>