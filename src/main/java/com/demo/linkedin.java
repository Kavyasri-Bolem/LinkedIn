package com.demo;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.awt.Desktop;
import java.io.*;
import java.net.URI;
  


public class linkedin extends HttpServlet{
	private static final long serialVersionUID = 1L;
	String next="checkbox.jsp";
	public static final String GOOGLE_SEARCH_URL = "https://www.google.com/search?q=";
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String fname = request.getParameter("fname");
		String  lname = request.getParameter("lname");
		String job = request.getParameter("job");
		String com = request.getParameter("com");
		String email = request.getParameter("email");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String active="Active";
		/**out.println(fname);
		out.println(lname);
		out.println(job);
		out.println(com);
		out.println(email);
		out.println(city);
		out.println(state);**/
		//String id = request.getParameter("name");
		//String[] a = id.split(" ");
		//int i=Integer.parseInt(a[0]);
		try{
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/linkedin","root","");
			Statement st = connection.createStatement() ;
			
			ResultSet rs=st.executeQuery("select * from nala");
			String fn;
			String un;
			String jo;
			String co;
			String em;
			String ci;
			String sta;
			
			while(rs.next()){
				int i=rs.getInt(1);
				if(fname==null){
					fn="";
					
				}
				else {
					 fn=rs.getString(2);
				    
					
				}
				if(lname==null) {
					un="";
					
				}
				else {
					un=rs.getString(3);
					
				}
				if(job==null) {
					jo="";
				     
					}
					else {
						jo=rs.getString(4);
					     
					}
				if(com==null) {
					co="";
				    
					}
					else {
						 co=rs.getString(5);
					     
					}
				if(email==null) {
					em="";
					}
					else {
						em=rs.getString(6);
						
					}
				if(city==null) {
					ci="";
				    
					}
					else {
						 ci=rs.getString(7);
					}
				if(state==null) {
					sta="";
					
				     
					}
					else {
						sta=rs.getString(8);
					    
					}
				String search=fn+"+"+un+"+"+jo+"+"+co+"+"+em+"+"+ci+"+"+sta;
				out.println(search);
				String searchURL = GOOGLE_SEARCH_URL +search;
				out.println(searchURL);
				Document doc=Jsoup.connect(searchURL).get();
				out.println(doc);
				Elements results = doc.select("cite");

				for (Element result : results) {
					if(result.className().equals("iUh30 qLRx3b tjvcx"))
					{
						String linkcheck=result.text();
						if(linkcheck.contains("linkedin.com"))
						{
							Element uid=result.selectFirst("span");
							String dlink="https://www.linkedin.com/in/"+uid.text().substring(2);
							PreparedStatement ps= connection.prepareStatement("update nala set link='"+dlink+"' where id='"+i+"'");
							ps.executeUpdate();
							if(!dlink.isEmpty()) {
								PreparedStatement ps1= connection.prepareStatement("update nala set status=? where id='"+i+"'");
								ps1.setString(1,active);
								ps1.executeUpdate();
							}
							//connection.close();
							//Desktop desk = Desktop.getDesktop();
							//desk.browse(new URI(dlink));
							//out.println(dlink);
							//HttpSession session=request.getSession();
							//session.setAttribute("link",dlink);
						   //response.sendRedirect(next);
						}
						break;
					}
				}
			}
			
			
	}
		
	catch(Exception e) {
		e.printStackTrace();
	}
}
}
