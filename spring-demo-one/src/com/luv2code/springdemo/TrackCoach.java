package com.luv2code.springdemo;

import org.springframework.http.converter.json.GsonBuilderUtils;
import org.w3c.dom.ls.LSOutput;

public class TrackCoach implements Coach {

    //create a private field FortuneService
    private FortuneService fortuneService;

    public TrackCoach() {
        System.out.println("Inside the no-arg TrackCoach constructor ");
    }

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "TrackCoach: Run a hard 5k";
    }

    @Override
    public String getDailyFortune() {
        return "TrackCoach: " + fortuneService.getFortune();
    }

    //add an init method
    public void doMyStartupStuff() {
        System.out.println("Trackoach: inside method doMyStartupStuff");
    }

    //add a destroy method
    public void doMyCleanupStuffYoYo() {
        System.out.println("TrackCoach: inside method doMyCleanupStuffYoYo");
    }

}
