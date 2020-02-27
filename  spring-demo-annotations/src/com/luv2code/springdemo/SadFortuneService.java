package com.luv2code.springdemo;

public class SadFortuneService implements FortuneService{

    public SadFortuneService() {
        System.out.println("Inside of the SadFortuneService() constructor");
    }

    @Override
    public String getFortune() {
        return "SadFortuneService: Today is a sad day";
    }
}
