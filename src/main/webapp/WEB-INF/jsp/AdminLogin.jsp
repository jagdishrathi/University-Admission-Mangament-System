<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AdminLogin</title>
<style>
body {
	background-image:
		url('C:/Users/hp/eclipse-workspace/University/src/main/webapp/WEB-INF/images/3.jpg');
}

form {
	border: 3px solid #f1f1f1;
	width: 430px;
	margin-left: 500px;
	margin-top: 100px;
}

h3 {
	text-align: center;
}

/* Full-width inputs */
input[type=text], input[type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

/* Set a style for all buttons */
button {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}

/* Add a hover effect for buttons */
button:hover {
	opacity: 0.8;
}

/* Extra style for the cancel button (red) */
.cancelbtn {
	width: auto;
	padding: 10px 18px;
	background-color: #f44336;
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
	padding: 16px;
	width: 400px;
}

/* The "Forgot password" text */
span.psw {
	float: right;
	padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
	span.psw {
		display: block;
		float: none;
	}
	.cancelbtn {
		width: 100%;
	}
}

h2 {
	color: red;
	border: 1px solid red;
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
			<label for="uname"><b>Username</b></label> <input type="text"
				placeholder="Enter Username" name="AdminId" required /> <label
				for="psw"><b>Password</b></label> <input type="password"
				placeholder="Enter Password" name="AdminPassword" required />

			<button type="submit">Login</button>
			<h2>${message}</h2>
		</div>
	</form>
</body>
</html>