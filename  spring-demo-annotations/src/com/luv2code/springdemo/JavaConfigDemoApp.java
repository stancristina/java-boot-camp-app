package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigDemoApp {

    public static void main(String[] args) {

        //load the Spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        //get the bean from spring container
        Coach theCoach = context.getBean("tennisCoach", Coach.class);
        //Coach coach = context.getBean("cricketCoach", Coach.class);

        //call a method on the bean
        System.out.println(theCoach.getDailyWorkout());
       // System.out.println(coach.getDailyWorkout());

        //call a method to get daily fortune
        System.out.println(theCoach.getDailyFortune());

        //close the context
        context.close();
    }
}
