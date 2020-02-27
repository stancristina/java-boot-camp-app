package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// default the bean id is tennisCoach(same name as the class, with lower t)
@Component
public class TennisCoach implements Coach {

    //create  the dependency
    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    /*@Autowired with constructor injection
    @Autowired
    public TennisCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }
     */

    //define my init method
    @PostConstruct
    public void doMyStyff() {
        System.out.println(">>TennisCoACH: inside of doMyStuff() method");
    }

    //defne my destroy method
    @PreDestroy
    public void doMyCleanUpStuff() {
        System.out.println(">>TennisCoach: insde of doMyCleanupStuff() method");
    }

    //define a default constructor
    public TennisCoach() {
        System.out.println(">> TennisCoach: inside default constructor");
    }

   /* //define a setter method
    @Autowired
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println(">> TennisCoach: inside setFortuneService() method");
        this.fortuneService = fortuneService;
    }
    */

    /*@Autowired
    public void doSomeCrazyStuff(FortuneService fortuneService) {
        System.out.println(">> TennisCoach: inside doSomeCrazyStuff() method");
        this.fortuneService = fortuneService;
    }
     */

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
