package com.sk;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApp {
	
	
	public static void main(String[] args) {
		
		//load the configuration file
		
		
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		//retrieve bean from spring container
		Coach theCoach=context.getBean("myCoach",Coach.class);
		
	
		
		
		
	
		
		//call methods on bean
		
		
		
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		//close the context
		context.registerShutdownHook();
		//context.close();
	}

}
