package com.sk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class StudentDAO {
	
	
	private String driver="com.mysql.cj.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/db";
	private String username="root";
	private String password="root";
	
	
	public void selectAllRows() throws ClassNotFoundException, SQLException
	{
		
		//load driver
	//	Class.forName(driver);
	
		//get a connection
		
		Connection con=DriverManager.getConnection(url,username,password);
		
		
		//execute query
		Statement stmt=con.createStatement();
		
		ResultSet rs=stmt.executeQuery("select * from db.hostelStudentinfo");
		while(rs.next())
		{
			int id=rs.getInt(1);
			String name=rs.getString(2);
			String fee=rs.getString(3);
			String food=rs.getString(4);
			
			System.out.println(id+" "+name+" "+fee+" "+food);
		}
		
	}
	

}
