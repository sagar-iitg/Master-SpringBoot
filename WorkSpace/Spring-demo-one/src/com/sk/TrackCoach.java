package com.sk;

public class TrackCoach implements Coach {

	
	
	private FortuneService fortuneService;
	
	public TrackCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {

		
		return "Track Coach";
		
	}

	@Override
	public String getDailyFortune() {

		//use my fortune
		
		return fortuneService.getFortune();
	}

}
