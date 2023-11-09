package com.sk;

public class CricketCoach implements Coach {

	
	
	private FortuneService fortuneService;
	
	
	
	public CricketCoach() {
		super();
		// TODO Auto-generated constructor stub
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

}
