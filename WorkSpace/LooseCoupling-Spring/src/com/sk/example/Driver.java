package com.sk.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {

	
	
	public static void main(String[] args) {
		
		
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("config1.xml");
		Airtel airtel=context.getBean("air",Airtel.class);
		
		airtel.activateService();
		context.close();
		
	}
}
