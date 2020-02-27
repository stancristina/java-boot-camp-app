package com.luv2code.springdemo;

public class BaseballCoach implements Coach{

    //define a private field for the dependency
    private FortuneService fortuneService;

    //define a constructor for dependency injection
    public BaseballCoach(FortuneService theFortuneService) {
        this.fortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "BaseballCoach: Spend 30 minute on batting practice";
    }

    @Override
    public String getDailyFortune() {

        //use my fortuneService to get a fortune
        return "BaseballCoach: " + fortuneService.getFortune();
    }

}
