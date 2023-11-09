package com.sk;

public class Airtel implements Sim{

	
	
	
	
	public Airtel() {
		super();
		System.out.println("Airtel Object created by Spring/IOC Container");
	}

	@Override
	public void calling() {
		// TODO Auto-generated method stub
		
		System.out.println("Calling from Airtel Mobile");
		
		
	}

	@Override
	public void data() {
		// TODO Auto-generated method stub
		
		System.out.println("Using Airtel  Mobile Data");
		
	}
	

}
