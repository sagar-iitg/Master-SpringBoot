package com.sk;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	
	
	public static void main(String[] args) {
		
		
		
		ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
		
		Student s=context.getBean("student",Student.class);
		
		s.cheating();
		
		((AbstractApplicationContext) context).close();
		
	}
	
}
