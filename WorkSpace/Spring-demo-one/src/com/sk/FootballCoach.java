package com.sk;

public class FootballCoach implements Coach {

	
	
	FortuneService fortuneService;
	
	
	//create a no-arg constructor
	
	public FootballCoach() {
		super();
		
		System.out.println("Football coach :inside no -arg constructor");
		// TODO Auto-generated constructor stub
	}
	public FootballCoach(FortuneService fortuneService) {
		super();
		
		this.fortuneService=fortuneService;
		
		//System.out.println("Football coach :inside no -arg constructor");
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	//setter method
	
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Football coach :inside setter method - setFortuneService");
		this.fortuneService = fortuneService;
	}




	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "football coach";
	}

	

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
