package com.sk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Human
{

	@Autowired
	@Qualifier("octopusHeart")
	private Heart heart;


	public Human()
	{
		System.out.println("default constructor");
		this.heart = new Heart();
		
	}

	public Human(Heart heart) {
		super();
		this.heart = heart;
		
		System.out.println("Human Constructor class-  paramatrized");
	}
	
	
	public void setHeart(Heart heart) {
		this.heart = heart;
		System.out.println("Setter Method Called Human-Classes // heart object");
		
	}
	
	public void startPumping()
	{
		
		if(heart!=null)
		{
			heart.pump();
			System.out.println("Name of Animal"+heart.getNameOfAnimal());
			System.out.println("No of heart "+ heart.getNoOfHeart());
		}
		else {
			System.out.println(heart);
			System.out.println("You are dead");
		}
	}
	
	
	

}
