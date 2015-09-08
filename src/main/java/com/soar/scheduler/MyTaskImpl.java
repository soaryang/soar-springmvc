package com.soar.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by user on 15/9/8.
 */
@Component
public class MyTaskImpl implements MyTask {

    @Scheduled(cron="0/5 * * * * ? ")
    public void say() {
        System.out.print("--------------->任务进行中");
    }
}
