/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.whnm.crudTareasProgramadas;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;

/**
 *
 * @author whnm
 */
public class MyMainCrudTareasProgramadas {

    public static void main(String[] args) {
        MyMainCrudTareasProgramadas main = new MyMainCrudTareasProgramadas();
//        List<ProcesoCierre> listaProcesoCierre = new ArrayList<>();
//        listaProcesoCierre.add(new ProcesoCierre("CIERRED", "com.whnm.simple_quartz.MyJob",
//                "0 48 14 * * ?", "cierre_diario"));
//        listaProcesoCierre.add(new ProcesoCierre("COMPFAC", "com.whnm.simple_quartz.MyJob",
//                "0 49 14 * * ?", "cierre_compensacion_facturacion"));
//        listaProcesoCierre.add(new ProcesoCierre("OTRO", "com.whnm.simple_quartz.MyJob",
//                "0 50 14 * * ?", "cierre_n"));
//
//        for (ProcesoCierre proCierre : listaProcesoCierre) {
//            try {
//                main.crearTareasProgramadas(proCierre);
//            } catch (SchedulerException ex) {
//                Logger.getLogger(MyMainCrudTareasProgramadas.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (ClassNotFoundException ex) {
//                Logger.getLogger(MyMainCrudTareasProgramadas.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (NoSuchMethodException ex) {
//                Logger.getLogger(MyMainCrudTareasProgramadas.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (InstantiationException ex) {
//                Logger.getLogger(MyMainCrudTareasProgramadas.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (IllegalAccessException ex) {
//                Logger.getLogger(MyMainCrudTareasProgramadas.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (IllegalArgumentException ex) {
//                Logger.getLogger(MyMainCrudTareasProgramadas.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (InvocationTargetException ex) {
//                Logger.getLogger(MyMainCrudTareasProgramadas.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        Scanner scan = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("******MANTENIMIENTO DE TAREAS PROGRAMADAS********");
            System.out.println("1.- Crear Tarea Programada");
            System.out.println("2.- Eliminar Tarea Programada");
            System.out.println("3.- Actualizar Tarea Programada");
            System.out.println("4.- Listar Tareas Programadas");
            System.out.println("5.- Finalizar");

            System.out.println("Ingresa una opcion del menu:");
            opcion = scan.nextInt();

            switch (opcion) {
                case 1: {
                    ProcesoCierre p = main.crearProcesoCierre();
                    try {
                        main.crearTareasProgramadas(p);
                    } catch (SchedulerException ex) {
                        Logger.getLogger(MyMainCrudTareasProgramadas.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(MyMainCrudTareasProgramadas.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (NoSuchMethodException ex) {
                        Logger.getLogger(MyMainCrudTareasProgramadas.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InstantiationException ex) {
                        Logger.getLogger(MyMainCrudTareasProgramadas.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(MyMainCrudTareasProgramadas.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalArgumentException ex) {
                        Logger.getLogger(MyMainCrudTareasProgramadas.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InvocationTargetException ex) {
                        Logger.getLogger(MyMainCrudTareasProgramadas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                case 2: {
                    try {
                        main.eliminarTrigger();
                    } catch (SchedulerException ex) {
                        Logger.getLogger(MyMainCrudTareasProgramadas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                case 3: {
                    try {
                        main.actualizarTrigger();
                        break;
                    } catch (SchedulerException ex) {
                        Logger.getLogger(MyMainCrudTareasProgramadas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                case 4: {
                    try {
                        main.listarTareasProgramadas();
                    } catch (SchedulerException ex) {
                        Logger.getLogger(MyMainCrudTareasProgramadas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                case 5:
                    System.err.println("adios");
                    break;
                default:
                    System.out.println("opcion incorrecta");
                    break;
            }

        } while (opcion != 5);

        System.exit(0);

    }

    public ProcesoCierre crearProcesoCierre() {
        Scanner scan = new Scanner(System.in);
        ProcesoCierre proCierre;
        String codigoProceso;
        String claseJob;
        String cronExpresion;
        String identificacion;
        System.out.println("Ingrese Codigo del Proceso");
        codigoProceso = scan.nextLine();
        System.out.println("Ingrese clase Job");
        claseJob = scan.nextLine();
        System.out.println("Ingrese Cron Expresion");
        cronExpresion = scan.nextLine();
        System.out.println("Ingrese identificacion");
        identificacion = scan.nextLine();
        proCierre = new ProcesoCierre(codigoProceso, claseJob, cronExpresion, identificacion);
        return proCierre;
    }

    public void crearTareasProgramadas(ProcesoCierre pCierre) throws SchedulerException, ClassNotFoundException, NoSuchMethodException, InstantiationException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        System.out.println("*****CREAR TAREAS PROGRAMADAS");
        Class claseLanzar = Class.forName(pCierre.getClaseJob());

        JobDetail jobDetail = JobBuilder.newJob(claseLanzar)
                .withDescription("PROCESOS DE CIERRES")
                .withIdentity(pCierre.getCodigoProceso())
                .usingJobData("PARAMETRO", pCierre.getCodigoProceso())
                .build();

//        JobDataMap data = jobDetail.getJobDataMap();
//        data.put("PARAMETRO", pCierre.getCodigoProceso());
        Trigger t1 = TriggerBuilder.newTrigger().withIdentity(pCierre.getIdentificacion())
                .withSchedule(CronScheduleBuilder.cronSchedule(pCierre.getCronExpresion())).build();

//        Set<Trigger> setTrigger = new HashSet();
//        setTrigger.add(t1);
        Scheduler sc = StdSchedulerFactory.getDefaultScheduler();
        sc.start();
        sc.scheduleJob(jobDetail, t1);
//        sc.addJob(jobDetail, true);
//        sc.rescheduleJob(tk, t1) cambia un trigger de clave tk por otro nuevo
//        sc.scheduleJobs(map, true); reemplaza el jobDetail y los triggers especificados
//          sc.scheduleJob(jobDetail, setTrigger, true);
    }

    public void listarTareasProgramadas() throws SchedulerException {
//        Scheduler sc = StdSchedulerFactory.getDefaultScheduler();
        System.out.println("***LISTA DE TAREAS PROGRAMADAS****");
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
//        List<String> calendarNames = sc.getCalendarNames();
//        System.out.println("***CALENDAR NAMES******");
//        for(String cal : calendarNames){
//            
//        }
//        List<JobExecutionContext> jobExecutionContext = sc.getCurrentlyExecutingJobs();
        for (String groupName : scheduler.getJobGroupNames()) {
            System.out.println("Entrando al groupName: " + groupName);
            for (JobKey jobKey : scheduler.getJobKeys(GroupMatcher.jobGroupEquals(groupName))) {

                String jobName = jobKey.getName();
                String jobGroup = jobKey.getGroup();

                //get job's trigger
                List<Trigger> triggers = (List<Trigger>) scheduler.getTriggersOfJob(jobKey);
                Date nextFireTime = triggers.get(0).getNextFireTime();

                System.out.println("[jobName] : " + jobName + " [groupName] : "
                        + jobGroup + " - " + nextFireTime);

            }

        }

    }

    public void actualizarTrigger() throws SchedulerException {
        String keyTrigerAnt;
        String nuevoCronExpresion;
        Scanner scan = new Scanner(System.in);
        System.out.println("***ACTUALIZAR TAREA PROGRAMADA POR TRIGGER****");
        System.out.println("Ingresar Codigo Proceso");
        keyTrigerAnt = scan.nextLine();
        System.out.println("Ingresar Nuevo Cron Expresion");
        nuevoCronExpresion = scan.nextLine();

        Trigger t1 = TriggerBuilder.newTrigger().withIdentity(keyTrigerAnt)
                .withSchedule(CronScheduleBuilder.cronSchedule(nuevoCronExpresion)).build();

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();

        TriggerKey tk = new TriggerKey(keyTrigerAnt);
        scheduler.rescheduleJob(tk, t1);
    }

    public void eliminarTrigger() throws SchedulerException {
        String keyJob;
        String nuevoCronExpresion;
        Scanner scan = new Scanner(System.in);
        System.out.println("***ELIMINAR TAREA PROGRAMADA****");
        System.out.println("Ingresar Codigo Proceso");
        keyJob = scan.nextLine();

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        JobKey jobKey = new JobKey(keyJob);
        scheduler.deleteJob(jobKey);
    }
}
