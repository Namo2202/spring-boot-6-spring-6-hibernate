package com.spring.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

    @PostConstruct
    public void doMyStuff() {
        System.out.println("in doMyStuff(): "+getClass().getSimpleName());
    }

    @PreDestroy
    public void doMyCleanStuff() {
        System.out.println("in doMyCleanStuff(): "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes :-)";
    }
}
