package com.soar.scheduler;

import org.springframework.stereotype.Component;

/**
 * Created by user on 15/9/8.
 */
@Component("anotherBean")
public class AnotherBean {
    public void printAnotherMessage(){
        System.out.println("I am called by Quartz jobBean using CronTriggerFactoryBean");
    }
}
