package com.sk;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	
	public static void main(String[] args) {
		
		
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		
		JDBCConnection jc=context.getBean("con",JDBCConnection.class);
		jc.display();
		
	}
}
