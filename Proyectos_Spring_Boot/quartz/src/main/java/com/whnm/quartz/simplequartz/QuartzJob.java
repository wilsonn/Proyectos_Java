/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.whnm.quartz.simplequartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author whnm
 */
public class QuartzJob implements Job{

    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        System.err.println("Hola tarea programada");
    }
    
}
