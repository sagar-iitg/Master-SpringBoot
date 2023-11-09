package com.sk;

public class Jio implements Sim{

	
	
	
	
	public Jio() {
		super();
		// TODO Auto-generated constructor stub
		
		System.out.println("Jio Object created by Spring/IOC Container");
	}

	@Override
	public void calling() {
		// TODO Auto-generated method stub
		
		System.out.println("Calling from Jio Mobile");
		
		
	}

	@Override
	public void data() {
		// TODO Auto-generated method stub
		
		System.out.println("Using Jio  Mobile Data");
		
	}
	

}
