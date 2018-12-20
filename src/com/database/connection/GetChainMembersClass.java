package com.database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.json.JSONObject;

public class GetChainMembersClass {

	public JSONObject getMember()
	{
		// TODO Auto-generated method stub
		String members= "";
		JSONObject jsonString = new JSONObject();
		try{  
		//step1 load the driver class  
		//Class.forName("oracle.jdbc.driver.OracleDriver"); 
			Class.forName("com.mysql.jdbc.Driver"); 
		  
		//step2 create  the connection object  
		//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");  
			Connection con=DriverManager.getConnection(  "jdbc:mysql://root.c57v61zm4svf.us-east-1.rds.amazonaws.com:3306/finassist_prod","root","finassistroot");  
		  
		//step3 create the statement object  
		/*PreparedStatement stmt=con.prepareStatement("insert into user (firstName,lastName,userName,password,email) values(?,?,?,?,?)");  
		 stmt.setString(1,firstName);
		 stmt.setString(2,lastName);
		 stmt.setString(3,userName);
		 stmt.setString(4,password);
		 stmt.setString(5,email);
		 int i=stmt.executeUpdate();  
		 System.out.println(i+" records inserted"); */

		  
		//step5 close the connection object  
		//con.close();  
		 // System.out.println("end");
			
			
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from wallet_info");  
			
			while(rs.next())  
			
				jsonString.put(rs.getString("accountName"), rs.getString("walletAddress")+"IP:"+rs.getString("personalIP"));
				
			
			//members=members+rs.getString("accountName")+" "+rs.getString("walletAddress")+"\n";  
			
			con.close();  
			//System.out.println(jsonString);
		}catch(Exception e){ System.out.println(e);}
		return jsonString;  
		}
	}


