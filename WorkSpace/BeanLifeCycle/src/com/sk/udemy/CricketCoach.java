package com.sk.udemy;

public class CricketCoach implements Coach {

	
	
	private FortuneService fortuneService;
	
	
	
	public CricketCoach() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("constructor crciker coach");
	}

	public CricketCoach(FortuneService fortuneService) {
		super();	
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		System.out.println("please do steching // chhakar lagao pura field ko");
		return "Cricket coach";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	//add an init method
	
	public void init() {
		System.out.println("init method");
	}
	
	public void destroy() {
		System.out.println("destroy method");
	}
	
	
	
	
	// add an destroy method
	
	

}
