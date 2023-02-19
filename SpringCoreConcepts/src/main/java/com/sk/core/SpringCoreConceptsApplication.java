package com.sk.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sk.core.couple.Person;

@SpringBootApplication
public class SpringCoreConceptsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCoreConceptsApplication.class, args);
		System.out.println("hello");
		
		
		Person p=new Person();
		p.playwithAnimal();
	}

}
