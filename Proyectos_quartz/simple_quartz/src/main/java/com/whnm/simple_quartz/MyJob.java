/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.whnm.simple_quartz;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

/**
 *
 * @author whnm
 */
public class MyJob implements Job{
    
//    private String parametro;
//
//    public MyJob(String parametro) {
//        this.parametro = parametro;
//    }

    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        /*aqui debe ir la funcionalidad que se lanzara de manera programada*/
        JobDataMap data = jec.getJobDetail().getJobDataMap();
        String parametro = data.getString("PARAMETRO");
        JobKey jobKey = jec.getJobDetail().getKey();
        System.out.println("Esta sera mi tarea programada con el parametro: "+parametro);
        System.out.println("Job Key: "+jobKey.getName());
        System.out.println("Descripcion: "+jec.getJobDetail().getDescription());
    }
    
}
