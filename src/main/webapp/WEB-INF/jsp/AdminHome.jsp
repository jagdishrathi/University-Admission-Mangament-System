<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home</title>
<style>
form {
	border: 3px solid #f1f1f1;
	width: 450px;
	margin-top: 150px;
	margin-left: 500px;
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
	margin: 24px 0 12px 0;
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

body {
	background-image:
		url("C:/Users/hp/eclipse-workspace/University/src/main/webapp/WEB-INF/images/3.jpg");
}
</style>
</head>
<body>
	<div class="imgcontainer">
		<img
			src="C:/Users/hp/eclipse-workspace/University/src/main/webapp/WEB-INF/jsp/3.jpg"
			alt="Avatar" class="avatar">
	</div>

	<div class="container">
		<button onclick="window.location.href = 'AdminStudent';">Student</button>
		<button onclick="window.location.href = 'AdminFaculty';">Faculty</button>
		<button onclick="window.location.href = 'AdminCollege';">College</button>
	</div>
</body>
</html>
