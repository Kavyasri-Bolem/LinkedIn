<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
<center>
<form action="register.java" align="center">
   <label>First Name:</label>
   <input type="text" name="fname" required><br><br>
   <label>Last Name:</label>
   <input type="text" name="lname" required><br><br>
   <label>Email &nbsp &nbsp:&nbsp&nbsp</label>
   <input type="email" name="email" required><br><br>
   <label>City &nbsp&nbsp:&nbsp&nbsp&nbsp&nbsp&nbsp</label>
   <input type="text" name="city" required><br><br>
   <label>State &nbsp&nbsp:&nbsp&nbsp&nbsp</label>
   <input type="text" name="state" required><br><br>
   <lable for="gender" name="gender">Gender &nbsp&nbsp:</lable>
   <input type="radio" id="gender" name="gender" value="male"/>Male
   <input type="radio" id="gender" name="gender" value="female"/>Female
   <br><br><input type="submit" value="submit">
</form>
</center>
</body>
</html>