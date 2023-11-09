package com.sk;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {
	
	
	
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
	    Sim sim=context.getBean("jio",Sim.class);
	    sim.calling();
	    sim.data();
	    
	    ((AbstractApplicationContext) context).close();
	    
	}
	

	
	
				
				
	
	

}
