package com.sk.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FoodCartDBUtil {

	public static List<Food> getFoodList() throws ClassNotFoundException, SQLException
	{
		
		
		String url="jdbc:mysql://localhost:3306/food";
		String userName="root";
		String password="root";
		
		
		
		ArrayList<Food> food=new ArrayList<>();
		
		//load Mysql
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		//get the connection
		
		Connection con=DriverManager.getConnection(url,userName,password);
		
		
		//create a statement
		
		Statement stmt=con.createStatement();
		
		ResultSet rs=stmt.executeQuery("select * from foodcart");
		
		
		while(rs.next())
		{
			
			int id=rs.getInt(1);
			String item=rs.getString(2);
			float price=rs.getFloat(3);
			
			Food f=new Food(id,item,price);
			food.add(f);
				
		}
		
		return food;
		
	}
	

	

}
