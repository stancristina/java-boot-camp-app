package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

    public static void main(String[] args) {

        //load the Spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //get the bean from spring container
        Coach theCoach = context.getBean("tennisCoach", Coach.class);
        //Coach coach = context.getBean("cricketCoach", Coach.class);

        //call a method on the bean
        System.out.println(theCoach.getDailyWorkout());
       // System.out.println(coach.getDailyWorkout());

        //call a method to get daily fotune
        System.out.println(theCoach.getDailyFortune());

        //close the context
        context.close();
    }
}
