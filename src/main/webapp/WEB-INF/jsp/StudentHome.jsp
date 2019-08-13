<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Student Home</title>
<style>
    body{        
        padding-top: 60px;
        padding-bottom: 40px;
        background-color: #66ffd9;
    }
    .fixed-header, .fixed-footer{
        width: 100%;
        position: fixed;        
        background: #333;
        padding: 10px 0;
        color: #fff;
    }
    .fixed-header{
        top: 0;
    }
    .fixed-footer{
        bottom: 0;
    }
    .container{
        width: 80%;
        margin: 0 auto; /* Center the DIV horizontally */
    }
    marquee{
    color:Red;
    font-size:20px;
    }
    input{
    background-color:black;
    color:white;
    }
    button {
	background-color: #4CAF50;
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	float: left;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}
#Logout{
	background-color: #4CAF50;
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	float: right;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}
</style>
</head>
<body>
    <div class="fixed-header">
        <div class="container" modelAttribute="studentProfile">
            <nav>
                <h1><input value="${studentID}"/></h1>
				<form modelAttribute="AddStudent" action="StudentUpdateProfile" method="post">
				<Button name ="studentID"  value="${studentID}"  type="Submit">Update Profile</Button>
				</form>
				<form modelAttribute="studentHallTicket" action="#" method="post">
				<Button value="${studentID}"  name ="studentID" type="Submit">Hall Ticket</Button>
				</form>
				<form modelAttribute="studentPerformance" action="#" method="post">
				<Button value="${studentID}"  name ="studentID" type="Submit">Performance</Button>
				</form>	
				<form modelAttribute="viewStudentProfile" action="#" method="post">
				<Button value="${studentID}"  name ="studentID" type="Submit">View Profile</Button>
				</form>	
				<button onclick="window.location.href = 'welcome1';" id="Logout">LogOut</button>		
            </nav>
            <marquee direction="left"> Welcome ${studentID} </marquee>
        </div>
    </div>
    <div class="container">
    </div>    
    <div class="fixed-footer">
        <div class="container">Copyright &copy; Valtech 2019</div>        
    </div>
</body>
</html>