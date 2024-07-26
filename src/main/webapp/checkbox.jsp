<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>select</title>
</head>
<body>

<h1>select the check boxes</h1>

<form action="linkedin">
  <input type="checkbox" id="fname" name="fname" value="firstname">
  <label for="fname"> First Name</label><br>
  <input type="checkbox" id="lname" name="lname" value="lastname">
  <label for="lname"> Last Name</label><br>
  <input type="checkbox" id="job" name="job" value="job">
  <label for="job">Job </label><br>
  <input type="checkbox" id="com" name="com" value="company" >
  <label for="com"> Company</label><br>
  <input type="checkbox" id="email" name="email" value="email">
  <label for="email"> Email</label><br>
  <input type="checkbox" id="city" name="city" value="city" >
  <label for="city">City</label><br>
  <input type="checkbox" id="state" name="state" value="state">
  <label for="state"> State</label><br><br>
  <input type="submit" value="Submit">
</form>

</body>
</html>