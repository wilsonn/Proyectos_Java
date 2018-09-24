/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.whnm.simple_quartz;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 *
 * @author whnm
 */
public class MyMainScheduler {
    public static void main(String[] args) throws SchedulerException, ClassNotFoundException {
//        Class claseLanzar = Class.forName("MyJob");
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class).build();
        //        Trigger t1 = TriggerBuilder.newTrigger().withIdentity("SimpleTrigger")
//                .startNow().build();
        Trigger t1 = TriggerBuilder.newTrigger().withIdentity("CronTrigger")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5)
                        .repeatForever()).build();
        
//        Trigger t1 = TriggerBuilder.newTrigger().withIdentity("CronTrigger")
//                .withSchedule(CronScheduleBuilder.cronSchedule("0 05 12 * * ?")).build();
        
        Scheduler sc = StdSchedulerFactory.getDefaultScheduler();
        sc.start();
        sc.scheduleJob(jobDetail, t1);
        
    }
}
