package com.sk.udemy;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class  BeanScopeDemoApp {

	
	public static void main(String[] args)
	{
		
		//load configuration file
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("bean-scope-properties.xml");
		Coach theCoach=(Coach)context.getBean("myCoach");
		Coach alphaCoach=(Coach)context.getBean("myCoach");
		// check if they are same bean
		
		boolean res=theCoach==alphaCoach;
		System.out.println(res);

		
		
		context.registerShutdownHook();
	
		//context.close();
		
		//retrieve bean from spring container 
		
		
		
		
	}
	
	
	
}
