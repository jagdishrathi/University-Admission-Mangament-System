<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
	border-spacing: 5px;
	border: 1px solid green;
}

td, th {
	border: 4px solid #33FFC6;
	text-align: left;
	padding: 8px;
}

th {
	color: red;
	background-color: #33FFC6;
}

td {
	color: blue;
}

h1 {
	text-align: center;
	color: orange;
}

.assignment {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 50%;
	border: 5px solid #33FFC6;
	margin-left: 150px;
	margin-right: 50px;
}
button {
	background-color: red;
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}
h1{
color:red;
border:3px solid green;
}
</style>
</head>
<body>
	<h1>Student Assignment</h1>
	<table>
	<form action="adminSubjectMarks" method="post" modelAttribute="adminSubjectMarks">
		<tr>
			<th>Student Id:</th>
			<td><input type="text" value="${Id}" name="Id" readonly/></td>
			<th>Student Name:</th>
			<td>${name}</td>
		</tr>
		<tr>
			<th>Branch:</th>
			<td><input type="text" value="${branch}" name="branch" readonly /></td>
			<th>Sem:</th>
			<td>${sem}</td>
		</tr>
	</table>
	<table class="assignment">
		<tr>
			<th>Subject</th>
			<th>Max Marks</th>
			<th>Min Marks</th>
			<th>Marks</th>
		</tr>
			<tr>
				<td>${subject[0]}</td>
				<td>100</td>
				<td>32</td>
				<td><input type="text" name="subject1" /></td>
			</tr>
			<tr>
				<td>${subject[1]}</td>
				<td>100</td>
				<td>32</td>
				<td><input type="text" name="subject2" /></td>
			</tr>
			<tr>
				<td>${subject[2]}</td>
				<td>100</td>
				<td>32</td>
				<td><input type="text" name="subject3" /></td>
			</tr>
		<tr>
			<th>Total Assignment Marks:</th>
			<td>300</td>
			<td>186</td>
			<td><button type="submit">Submit</button></td>
		</tr>
		<h1>${message}</h1>
		</form>
	</table>
	<button onclick="window.location.href = 'AdminStudentFilter';">Back</button>
</body>
</html>