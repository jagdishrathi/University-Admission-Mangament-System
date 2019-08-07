<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Filter Student</title>
<style>
* {
	box-sizing: border-box
}

/* Add padding to containers */
.container {
	padding: 16px;
	width: 450px;
	margin-left: 500px;
	border: 2px solid orange;
}

/* Overwrite default styles of hr */
hr {
	border: 1px solid #f1f1f1;
	margin-bottom: 10px;
}

/* Set a style for the submit/register button */
.registerbtn {
	background-color: #4CAF50;
	color: white;
	padding: 16px 20px;
	margin: 8px 0;
	border: none;
	width: 100%;
}

.select-css {
	display: block;
	font-size: 14px;
	font-family: sans-serif;
	color: black;
	padding: 5px;
	width: 100%;
	box-sizing: border-box;
	margin: 0;
	border: 1px solid #4CAF50;
	box-shadow: 0 1px 0 1px rgba(0, 0, 0, .04);
	border-radius: 5px;
}

body {
	padding: 3rem;
}
</style>
</head>
<body>
	<form action="AdminStudentPerformance"
		modelAttribute="adminStudentFilter" method="Post">
		<div class="container">
			<h1>Student Filter</h1>
			<hr>

			<label><b>Branch</b></label> <select class="select-css"
				name="branchId">
				<option value="CSE">Computer Science</option>
				<option value="CV">Civil</option>
				<option value="MECH">Mechanical</option>
				<option value="ISE">Information Science</option>
			</select><br> <label><b>Sem</b></label> <select class="select-css"
				name="semId">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
			</select><br>
			<hr>
			<button type="submit" class="registerbtn">Submit</button>
		</div>
	</form>
</body>
</html>