package com.soar.scheduler;

import org.springframework.stereotype.Component;

/**
 * Created by user on 15/9/8.
 */
@Component("myTaskBean")
public class MyTaskBean {

    public void printMessage() {
        System.out.println("I am called by MethodInvokingJobDetailFactoryBean using SimpleTriggerFactoryBean");
    }

}
