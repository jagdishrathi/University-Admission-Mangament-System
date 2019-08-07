<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table, td, th {
	border: 1px solid #ddd;
	text-align: left;
}

table {
	border-collapse: collapse;
	border: 1px solid black;
	width: 100%;
}

th, td {
	padding: 15px;
	margin: 5px auto;
}

th {
	background-color: #4CAF50;
	color: white;
}

h1 {
	color: red;
	text-align: center;
}

button {
	background-color: #4CAF50;
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

input[type=text] {
	width: 75%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}
</style>
</head>
<body>
	<div class="container">
		<h1>Student List</h1>
		<table class="table">
			<thead>
				<tr>
					<th>StudentID</th>
					<th>StudentName</th>
					<th>Branch</th>
					<th>Sem</th>
					<th>Assignment</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="studentFilter" items="${studentPerformance}">
					<form action="AdminStudentAssignment" method="post"
						modelAttribute="adminStudentAssignment">
						<tr>
							<td><input value="${studentFilter[0]}" name="studentId"
								type="text" readonly /></td>
							<td><input name="studentName" value="${studentFilter[1]}"
								type="text" readonly /></td>
							<td><input name="studentBranch" value="${studentFilter[2]}"
								type="text" readonly /></td>
							<td><input name="studentSem" value="${studentFilter[3]}"
								type="text" readonly /></td>
							<td><input name="studentAssignment"
								value="${studentFilter[4]}" type="text" readonly /></td>
							<td><button type="submit">Edit</button></td>
						</tr>
					</form>
				</c:forEach>
			</tbody>
		</table>
		<button onclick="window.location.href = 'AdminStudent';">Back</button>
	</div>
</body>
</html>