package com.sk.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
	
	
	
	//dependency
	
	@Autowired
	Animal animal;
	
	
	
	public Person(Animal animal) {
		
		this.animal = animal;
	}



	public void playwithAnimal() {
		//using Animal
		animal.play();
	}

}
