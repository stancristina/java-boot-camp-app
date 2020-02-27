package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

    public static void main(String[] args) {

        //load the Spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        //get the bean from spring container
        //Coach theCoach = context.getBean("swimCoach", Coach.class);
        //Coach coach = context.getBean("cricketCoach", Coach.class);
        SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);

        //call a method on the bean
        System.out.println(theCoach.getDailyWorkout());
       // System.out.println(coach.getDailyWorkout());

        //call a method to get daily fortune
        System.out.println(theCoach.getDailyFortune());

        //cal our new sim method ..has te props values injected
//        System.out.println(theCoach.getEmail());
//        System.out.println(theCoach.getTeam());

        //close the context
        context.close();
    }
}
