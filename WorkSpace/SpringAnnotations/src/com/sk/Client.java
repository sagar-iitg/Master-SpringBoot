package com.sk;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Client {
	
	
	public static void main(String[] args) {
		
		 
		//System.out.println("Hello Spring");
		
		ApplicationContext context=new AnnotationConfigApplicationContext(Config.class);
		
		College clg=context.getBean("collegeBean",College.class);
		System.out.println("spring creted this object"+clg);
		clg.test();
		((AbstractApplicationContext) context).close();
		
		
	
	
	}

}
