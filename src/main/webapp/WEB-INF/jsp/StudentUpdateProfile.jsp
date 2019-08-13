<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Registeration</title>
    <style>
         * {box-sizing: border-box} 

.container {
  padding: 16px;
  width:450px;
  margin-left: 400px;
  border: 2px solid orange;
}

input[type=text], input[type=password], input[type=email] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 10px;
}

.registerbtn {
  background-color: #4CAF50;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  width: 100%;
}

.signin {
  background-color: #f1f1f1;
  text-align: center;
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
    border: 1px solid  #4CAF50;
    box-shadow: 0 1px 0 1px rgba(0,0,0,.04);
    border-radius: 5px;
}




body {
        background-color: #66ffd9;
}
    </style>
    
    <script>
    </script>
</head>
<body>
    <form action="updateStudent" method="post" modelAttribute="updateStudent">
        <div class="container">
          <h1>Update Profile</h1>
          <hr>
          
      	  <label><b>SID</b></label>
      	  <input type="text" name="sid"  />
      	  
          <label><b>Name</b></label>
          <input type="text" placeholder="Enter Name " name="name" required>

          <label><b>Email</b></label>
          <input type="email" placeholder="Enter Email" name="email" required>

          <label><b>Branch</b></label>
          <select class="select-css" name="branch">
                <option value="CSE">Computer Science</option>
                <option value="CV">Civil</option>
                <option value="ME">Mechanical</option>
                <option value="ISE">Information Science</option>
           </select><br>
           <label><b>Sem</b></label>
           <select class="select-css" name="sem">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
           </select><br>

           <label><b>PhoneNumber</b></label>
           <input type="text" placeholder="Enter Phone  Number" name="phonenumber" pattern="[789][0-9]{9}" title="Enter valid Mobile Number" required>
      
          <label><b>Update Password</b></label>
          <input type="password" placeholder="Enter Password" name="password" required>
          <hr>
          <button type="submit" class="registerbtn">Register</button>
        </div>
      </form>
</body>
</html>