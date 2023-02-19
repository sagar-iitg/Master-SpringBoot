package com.sk.loose.coupling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sk.loose.coupling.concepts.Cat;

import com.sk.loose.coupling.concepts.Animal;
import com.sk.loose.coupling.concepts.Person;

@SpringBootApplication
public class SpringCoreConceptsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCoreConceptsApplication.class, args);
		System.out.println("hello");
		
		Animal a=new Cat();
		Person p=new Person(a);
		
		p.playwithAnimal();
	}

}
