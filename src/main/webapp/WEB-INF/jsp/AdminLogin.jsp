<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AdminLogin</title>
<style>
body {
	background-color: #66ffd9;
}

form {
	border: 3px solid #f1f1f1;
	width: 40%;
	margin-left: 27%;
	margin-top: 7%;
}

h3 {
	text-align: center;
}

/* Full-width inputs */
input[type=text], input[type=password] {
	width: 36%;
	padding: 4% 4%;
	margin: 4% 0 0 4%;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

/* Set a style for all buttons */
button {
	background-color: #4CAF50;
	color: white;
	padding: 3% 4%;
	margin: 3% 4%;
	border: none;
	cursor: pointer;
	width: 36%;
}


/* Center the avatar image inside this container */
.imgcontainer {
	text-align: center;
	margin-left: 110px;
	margin-top: 10px;
	width: 200px;
}

/* Avatar image */
img.avatar {
	width: 40%;
	border-radius: 50%;
}

/* Add padding to containers */
.container {
	padding: 5%;
	margin-left:25%;
}


h2 {
	color: red;
}
</style>
</head>
<body>
	<form action="AdminLogin" modelAttribute="adminlogin" method="post">
		<div class="imgcontainer">
			<img
				src="C:/Users/hp/eclipse-workspace/University/src/main/webapp/WEB-INF/images/logo.png"
				alt="Avatar" class="avatar">
		</div>
		<h3>Admin Login</h3>
		<div class="container">
			<label><b>Username</b></label> 
			<input type="text" placeholder="Enter Username" name="AdminId" required /><br>
			 <label><b>Password</b></label> 
			 <input type="password" placeholder="Enter Password" name="AdminPassword" required /><br>
			<button type="submit">Login</button>
			<h2>${message}</h2>
		</div>
	</form>
</body>
</html>