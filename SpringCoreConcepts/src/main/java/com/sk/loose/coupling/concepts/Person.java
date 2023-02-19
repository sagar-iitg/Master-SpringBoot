package com.sk.loose.coupling.concepts;

public class Person {
	
	
	Animal animal;
	
	
	
	public Person(Animal animal) {
		
		this.animal = animal;
	}



	public void playwithAnimal() {
		//using Animal
		animal.play();
	}

}
