package com.sk;

public class Vodafone implements Sim{

	
	
	
	public Vodafone() {
		super();
		// TODO Auto-generated constructor stub
		
		System.out.println("Vodafone Object created by Spring/IOC Container");
	}
	
	@Override
	public void calling() {
		// TODO Auto-generated method stub
		
		System.out.println("Calling from Vodafone Mobile");
		
		
	}

	@Override
	public void data() {
		// TODO Auto-generated method stub
		
		System.out.println("Using Vodafone  Mobile Data");
		
	}
	

}
