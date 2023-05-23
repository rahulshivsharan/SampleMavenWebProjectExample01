package com.sam.proj;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestingServletApp extends HttpServlet{
	
	@Override
	public void init(ServletConfig config) {
		System.out.println("Servlet initialised...");
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Date date = null;
		PrintWriter io =  null;
		DateFormat dateFormat = null;
		StringBuffer strb = null;
		String printMe = null;
		try {
			dateFormat = new SimpleDateFormat("dd:MMM:yyyy h:mm:ss a");
			response.setContentType("text/html");
			io =  response.getWriter();
			date = new Date();			
			printMe = dateFormat.format(date);
			
			
			strb = new StringBuffer();
			strb.append("<!DOCTYPE html>")
				.append("<html>")
				.append("<head>")
				.append("<title>Servlet App One</title>")
				.append("<body>")
				.append("<h1> This is my servlet ")
				.append(printMe)
				.append("</h1>")
				.append("</body>")
				.append("</head>")
				.append("</html>");
			
			io.print(strb.toString());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}		
	}
}
