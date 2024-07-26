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
  


public class link extends HttpServlet{
	private static final long serialVersionUID = 1L;
	String next="index.jsp";
	public static final String GOOGLE_SEARCH_URL = "https://www.google.com/search?q=";
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("filter");
		String[] a = id.split(" ");
		int k=Integer.parseInt(a[1]);
		
		try{
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/linkedin","root","");
			Statement st = connection.createStatement() ;
			
			ResultSet rs=st.executeQuery("select * from nala");
			String active="Active";
			if(k==1) {
			while(rs.next()){
				int i=rs.getInt(1);
				String fn=rs.getString(2);
				String un=rs.getString(3);
				//String job=rs.getString(4);
				//String search=fn+"+"+un+"+"+job;
				String search=fn+"+"+un;
				String searchURL = GOOGLE_SEARCH_URL +search;
				Document doc=Jsoup.connect(searchURL).get();
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
						  // response.sendRedirect(next);
						}
						break;
					}
				}
				
			}
		}
			else if(k==2) {
				while(rs.next()){
					int i=rs.getInt(1);
					String fn=rs.getString(2);
					String un=rs.getString(3);
					String job=rs.getString(4);
					String search=fn+"+"+un+"+"+job;
					//String search=fn+"+"+un;
					String searchURL = GOOGLE_SEARCH_URL +search;
					Document doc=Jsoup.connect(searchURL).get();
					Elements results = doc.select("cite");

					for (Element result : results) {
						if(result.className().equals("iUh30 qLRx3b tjvcx"))
						{
							String linkcheck=result.text();
							if(linkcheck.contains("linkedin.com"))
							{
								Element uid=result.selectFirst("span");
								String dlink="https://www.linkedin.com/in/"+uid.text().substring(2);
								PreparedStatement ps= connection.prepareStatement("update signin set link='"+dlink+"' where id='"+i+"'");
								ps.executeUpdate();
								if(!dlink.isEmpty()) {
									PreparedStatement ps1= connection.prepareStatement("update signin set active=? where id='"+i+"'");
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
			else if(k==3) {
				while(rs.next()){
					int i=rs.getInt(1);
					String fn=rs.getString(2);
					String un=rs.getString(3);
					String job=rs.getString(4);
					String com=rs.getString(5);
					String search=fn+"+"+un+"+"+job+"+"+com;
					//String search=fn+"+"+un;
					String searchURL = GOOGLE_SEARCH_URL +search;
					Document doc=Jsoup.connect(searchURL).get();
					Elements results = doc.select("cite");

					for (Element result : results) {
						if(result.className().equals("iUh30 qLRx3b tjvcx"))
						{
							String linkcheck=result.text();
							if(linkcheck.contains("linkedin.com"))
							{
								Element uid=result.selectFirst("span");
								String dlink="https://www.linkedin.com/in/"+uid.text().substring(2);
								PreparedStatement ps= connection.prepareStatement("update signin set link='"+dlink+"' where id='"+i+"'");
								ps.executeUpdate();
								if(!dlink.isEmpty()) {
									PreparedStatement ps1= connection.prepareStatement("update signin set active=? where id='"+i+"'");
									ps1.setString(1,active);
									ps1.executeUpdate();
								}
								//connection.close();
								//Desktop desk = Desktop.getDesktop();
								//desk.browse(new URI(dlink));
								//out.println(dlink);
								//HttpSession session=request.getSession();
								//session.setAttribute("link",dlink);
							   //response.sendRedirect("index.jsp");
							}
							break;
						}
					}
					
				}
			}
			
	}
		
	catch(Exception e) {
		e.printStackTrace();
	}
	
}
}
