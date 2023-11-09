package com.sk.example;

public class Airtel {

	
	
	private Service service;

	public void setService(Service service)
	{
		this.service = service;
	}
	
	public void activateService()
	{
		service.service();
	}
	
}
