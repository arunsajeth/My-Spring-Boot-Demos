<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>

<style>
	*{
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	list-style: none;
	font-family: 'Montserrat', sans-serif;
}

 

body{
	background: #84889c;
}

.wrapper{
	min-height: 100vh;
	display: flex;
	justify-content: center;
	align-items: center;
}

 

.registration_form{
	background: black;
	padding: 25px;
	border-radius: 5px;
	width: 400px;
}

 

.registration_form .title{
	text-align: center;
	font-size: 20px;
	text-transform: uppercase;
	color: white;
	letter-spacing: 5px;
	font-weight: 700;
}

 

.form_wrap{
	margin-top: 35px;
}

 

.form_wrap .input_wrap{
	margin-bottom: 15px;
}

 

.form_wrap .input_wrap:last-child{
	margin-bottom: 0;
}

 

.form_wrap .input_wrap label{
	display: block;
	margin-bottom: 3px;
	color: #9597a6;
}

 

.form_wrap .input_grp{
	display: flex;
	justify-content: space-between;
}

 

.form_wrap .input_grp  input[type="text"]{
	width: 165px;
}

 

.form_wrap  input[type="text"]{
	width: 100%;
	border-radius: 3px;
	border: 1px solid #9597a6;
	padding: 10px;
	outline: none;
}

 

.form_wrap  input[type="text"]:focus{
	border-color: #ebd0ce;
}

 

.form_wrap ul{
	background: #fff;
	padding: 8px 10px;
	border-radius: 3px;
	display: flex;
	justify-content: center;
}

 

.form_wrap ul li:first-child{
	margin-right: 15px;
}

 

.form_wrap ul .radio_wrap{
	position: relative;
	margin-bottom: 0;
}

 

.form_wrap ul .radio_wrap .input_radio{
	position: absolute;
	top: 0;
	right: 0;
	opacity: 0;
}

 

.form_wrap ul .radio_wrap span{
	display: inline-block;
	font-size: 14px;
	padding: 3px 20px;
	border-radius: 3px;
	color: #545871;
}

 

.form_wrap .input_radio:checked ~ span{
	background: #ebd0ce;
}

 

.form_wrap .submit_btn{
	width: 100%;
	background: red;
	padding: 10px;
	border: 0;
	border-radius: 3px;
	text-transform: uppercase;
	letter-spacing: 3px;
	cursor: pointer;
}

 

.form_wrap .submit_btn:hover{
	background: green;
}
</style>

</head>

<body>

<%@ include file = "menu.jsp" %>


<div class="wrapper">
<div class="registration_form">
<div class="title">
Registration Form
</div>
<form action="add">
<div class="form_wrap">
<div class="input_wrap">
<label for="email">EMPLOYEE ID</label>
<input type="text" name="eid" value="" placeholder="Enter the ID" >
</div>
<div class="input_wrap">
<label for="email">EMPLOYEE NAME</label>
<input type="text" name="ename" value="" placeholder="Enter the Name">
</div>
<div class="input_wrap">
<label for="email">EMPLOYEE SALARY</label>
<input type="text" name="salary" value="" placeholder="Enter the Salary">
</div>
<div class="input_wrap">
<label for="email">EMPLOYEE DEPARTMENT</label>
<input type="text" name="dept" value="" placeholder="Enter the Department">
</div>

<div class="input_wrap">
<input type="submit" value="Add" class="submit_btn">
</div>
</div>
</form>
</div>
</div>
</body>
</html>