package com.home.mycafe.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyCafeControllers {

	
	//Return the welcome page	
	@RequestMapping("/cafe")
	public String showWelcomePage(Model model)
	{
		
		
		//sending data to the view (jsp page)
		
		//String myName="Sagar";
		//model.addAttribute("myNameValue",myName);
		model.addAttribute("myWebsiteHeader","MOM's CAFE");
		
		return "welcome-page";
	}
	
	
	@RequestMapping("/processOrder")
	public String processOrder(HttpServletRequest request, Model model)
	{
		
		//handle the data received from the user
		String userEnteredValue=request.getParameter("foodType");
		
		//set the user data and send it to view
		model.addAttribute("userInput",userEnteredValue );
		return "process-order";
		
		
		
	}
}
