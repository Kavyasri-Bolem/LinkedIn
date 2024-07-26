<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%ResultSet resultset =null;%>

<HTML>
<HEAD>
    <TITLE>Linkedin</TITLE>
    
    </script>
</HEAD>

<BODY BGCOLOR="aqua">

<form action="link">
<center>
<h1>
Filter 1:Frist name,Last name <br>
Filter 2:Frist name,Last name,Job title <br>
Filter 3:Frist name,Last name,Job title,Comapny name <br>
</h1>
    
        <h2>choose a filter</h2>
        <select value="filter" id="select1" name="filter">
        
            <option>Filter 1</option>
            <option>Filter 2</option>
            <option>Filter 3</option> 
         
       </select>
      
       
       
     <!--  <input type="file" name="file" size="100" required>
       <br><br>
     <h1>  Enter index:</h2><br>From:<input type="text" name="from" id="from" required>
       To:<input type="text" name="to" id="to">
        -->  
        <input type="submit" value="Ok" >

      
</center>

</form>


</BODY>
</HTML>