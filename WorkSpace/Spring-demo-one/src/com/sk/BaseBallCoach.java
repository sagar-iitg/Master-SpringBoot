package com.sk;

public class BaseBallCoach implements Coach
{
	
	
	
	
	//
	
	private FortuneService fortuneService;
	
	
	
	
	
	public BaseBallCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
	
		
		return "Base ball Coach";
		
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
