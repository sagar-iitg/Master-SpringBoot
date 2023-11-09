package com.sk.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Foodcart
 */
@WebServlet("/menu")
public class Foodcart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		
		//get the data from the database (model)
		
		//String[] foodItems= {"biryani","pizza","chicken"};
		//request.setAttribute("foodItems", foodItems);
		
		
		try {
			List<Food> foodItems=FoodCartDBUtil.getFoodList();
			request.setAttribute("foodItems", foodItems);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		//redirect to a different page
		
		RequestDispatcher   dispatcher=request.getRequestDispatcher("show-food.jsp");
		
		dispatcher.forward(request, response);
		
		
		
		
		
		
	
	
	}

}
