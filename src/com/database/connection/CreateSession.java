package com.database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

public class CreateSession {
	public String insert(String userName,String password, String sessionId)
	{
		//HttpSession session =null;
		String op ="";
	try{  
	//step1 load the driver class  
	//Class.forName("oracle.jdbc.driver.OracleDriver"); 
		Class.forName("com.mysql.jdbc.Driver"); 
	  
	//step2 create  the connection object  
	//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");  
		Connection con=DriverManager.getConnection(  "jdbc:mysql://root.c57v61zm4svf.us-east-1.rds.amazonaws.com:3306/finassist_prod","root","finassistroot");  
	  
	
		
		
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from user where userName='"+userName+"' and password='"+password+"'");  
		if(rs.isBeforeFirst())  
		{
			 //session = request.getSession();
			//session.setAttribute("fname", rs.getString("firstName"));
			
			op="success";
			Statement stmt1=con.createStatement();  
			System.out.println(sessionId);
			int rs1=stmt1.executeUpdate("update user set sessionId='"+sessionId+"' where userName='"+userName+"'");
			System.out.println(rs1);
			
		}else
		{
			op= "fail";
			String fail="";
			Statement stmt1=con.createStatement();  
			System.out.println(sessionId);
			int rs1=stmt1.executeUpdate("update user set sessionId='"+fail+"' where userName='"+userName+"'");
			System.out.println(rs1);
		}
		
		
		System.out.println(op);
		rs.close();
		con.close();
		 return op;
		
	}catch(Exception e){ System.out.println(e);}
	System.out.println(op);
	return op;  
	}
}
