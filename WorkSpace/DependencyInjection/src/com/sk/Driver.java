package com.sk;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {
	
	
	public static void main(String[] args) {
		
		
		ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
		
		Student s=context.getBean("student",Student.class);
		
		System.out.println("app name-----"+context.getApplicationName()+
				context.getDisplayName()+"\n"+"startup"+context.getStartupDate());
		//System.out.println(s.fun());
		
		
	}

}
