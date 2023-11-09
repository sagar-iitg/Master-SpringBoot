package com.sk;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		
		
		
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("beans.xml loaded");
		
		Student s=context.getBean("student",Student.class);
		
	
	
		System.out.println(s.toString());
		((AbstractApplicationContext) context).close();
		
		
	}

}
