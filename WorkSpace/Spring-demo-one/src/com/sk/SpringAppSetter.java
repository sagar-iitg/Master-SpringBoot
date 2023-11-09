package com.sk;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAppSetter {

	
	
	public static void main(String[] args) {
		 
		
		
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach c=context.getBean("myFootballCoach",Coach.class);
		
		System.out.println(c.getDailyFortune());
		System.out.println(c.getDailyWorkout());
		
		context.close();
		
	}
}
