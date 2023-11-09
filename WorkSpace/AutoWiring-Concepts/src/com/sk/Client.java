package com.sk;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
	
	
	public static void main(String[] args) 
	{
		
		
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		Human h=context.getBean("human",Human.class);
		h.startPumping();
		((AbstractApplicationContext) context).close();
		
		
		
	}

}
