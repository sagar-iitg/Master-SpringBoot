package com.sk.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringClass {
	
	
	public static void main(String[] args) {
		
		
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext1.xml");
		
		Car c=context.getBean("myCar",Car.class);
		
		c.drive();
		context.close();
		
		
		
	}

}
