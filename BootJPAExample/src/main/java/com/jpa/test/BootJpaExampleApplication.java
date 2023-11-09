package com.jpa.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootJpaExampleApplication {

	public static void main(String[] args) {
		 SpringApplication.run(BootJpaExampleApplication.class, args);
		 
		// UserRepository userRepo=context.getBean(UserRepository.class);
				 
		 User user=new User(1,"sk","giridih");
		
		 
		
		
	}

}
