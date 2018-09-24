/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.whnm.dinamica_class_job;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 *
 * @author whnm
 */
public class MyMainSchedulerDinamico {

    public static void main(String[] args) throws SchedulerException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        
        Class claseLanzar = Class.forName("com.whnm.simple_quartz.MyJob"); //al ser string puedes guardar y recuperarlo de una base de datos

        JobDetail jobDetail = JobBuilder.newJob(claseLanzar).build();
        JobDataMap data = jobDetail.getJobDataMap();
        data.put("PARAMETRO", "XXXX"); // se pueden traer de una base de datos
        //        Trigger t1 = TriggerBuilder.newTrigger().withIdentity("SimpleTrigger")
//                .startNow().build();
//        Trigger t1 = TriggerBuilder.newTrigger().withIdentity("CronTrigger")
//                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5)
//                        .repeatForever()).build();

        Trigger t1 = TriggerBuilder.newTrigger().withIdentity("CronTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 05 12 * * ?")).build(); //cron es una cadena que se puede traer de una basse de datos

        Set<Trigger> setTrigger = new HashSet();
        setTrigger.add(t1);
        Scheduler sc = StdSchedulerFactory.getDefaultScheduler();
        sc.start();
//        sc.scheduleJob(jobDetail, t1);
        sc.scheduleJob(jobDetail, setTrigger, true);

    }
    
}
