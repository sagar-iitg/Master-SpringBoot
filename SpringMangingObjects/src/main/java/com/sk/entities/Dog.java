package com.sk.entities;

import org.springframework.stereotype.Component;

@Component
public class Dog implements Animal{

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("dog is playing");
		
	}
	

}
