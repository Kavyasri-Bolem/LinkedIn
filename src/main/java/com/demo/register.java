package com.demo;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
public class register extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String fname = request.getParameter("fname");
		String  lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String gender =request.getParameter("gender");
		out.print("Welcome!!!! "+fname +'\n');
		out.print("          Your Entered details are:");
		out.print("          First name:"+fname);
		out.print("          Last name:"+lname);
		out.print("          Email:"+email);
		out.print("          City:"+city);
		out.print("          State:"+state);
		out.print("          Gender:"+gender);
		
	}
}
