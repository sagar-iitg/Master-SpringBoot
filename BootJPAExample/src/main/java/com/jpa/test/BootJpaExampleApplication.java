package com.jpa.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootJpaExampleApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		 SpringApplication.run(BootJpaExampleApplication.class, args);
		 
		// UserRepository userRepo=context.getBean(UserRepository.class);
				 




		 
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		User user=new User("rahul","patna");
		userRepository.save(user);

	}
}
