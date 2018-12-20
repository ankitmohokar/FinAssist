package com.database.connection;
import java.sql.*;  
public class ConnectionManager{  

public void insert(String firstName,String lastName,String userName,String password,String email)
{
try{  
//step1 load the driver class  
//Class.forName("oracle.jdbc.driver.OracleDriver"); 
	Class.forName("com.mysql.jdbc.Driver"); 
  
//step2 create  the connection object  
//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");  
	Connection con=DriverManager.getConnection(  "jdbc:mysql://root.c57v61zm4svf.us-east-1.rds.amazonaws.com:3306/finassist_prod","root","finassistroot");  
  
//step3 create the statement object  
PreparedStatement stmt=con.prepareStatement("insert into user (firstName,lastName,userName,password,email) values(?,?,?,?,?)");  
 stmt.setString(1,firstName);
 stmt.setString(2,lastName);
 stmt.setString(3,userName);
 stmt.setString(4,password);
 stmt.setString(5,email);
 int i=stmt.executeUpdate();  
 System.out.println(i+" records inserted"); 

  
//step5 close the connection object  
//con.close();  
 // System.out.println("end");
	
	
	//Statement stmt=con.createStatement();  
	//ResultSet rs=stmt.executeQuery("select * from user");  
	//while(rs.next())  
	//System.out.println(rs.next());  
	con.close();  
	System.out.println("success");
}catch(Exception e){ System.out.println(e);}  
}
}
 