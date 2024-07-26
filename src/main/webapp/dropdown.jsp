<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%ResultSet resultset =null;%>

<HTML>
<HEAD>
    <TITLE>Linkedin</TITLE>
    <script>
    function drop(){
    	
    }
    
    </script>
</HEAD>

<BODY BGCOLOR="aqua">

<%
    try{
Connection connection = 
         DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/linkedin","root","");

       Statement statement = connection.createStatement() ;

       resultset =statement.executeQuery("select * from signin") ;
%>
<!-- 
<form action="link">
<center>
    <h1> Choose the Person</h1>
    
        <select value="name" id="select1" name="name">
        <%  while(resultset.next()){  %>
        
            <option  ><%= resultset.getString(9) %></option> 
       <% } %>
        
        </select>
        <input type="submit" value="get profile" >
        
        <input type="text" value="<%=resultset.getString(10)%>" >
      
</center>

</form>
 -->
 <form action="link">
 <center>
 <h1>FILTER 1:</h1>
 <h2>1. First name  2.Last name  3.Job  4.Company</h2>
 <input type="submit" value="get excel sheet">
 </center>
 </form>
 
 
 <form action="link">
 <center>
 <h1>FILTER 1:</h1>
 <h2>1. First name  2.Last name  3.Job  </h2>
 <input type="submit" value="get excel sheet">
 </center>
 </form>
 
 <form action="link">
 <center>
 <h1>FILTER 1:</h1>
 <h2>1. First name  2.Last name  3.Job  4.Company</h2>
 <input type="submit" value="get excel sheet">
 </center>
 </form>

<%
        }
        catch(Exception e)
        {
             out.println("wrong entry"+e);
        }
%>

</BODY>
</HTML>