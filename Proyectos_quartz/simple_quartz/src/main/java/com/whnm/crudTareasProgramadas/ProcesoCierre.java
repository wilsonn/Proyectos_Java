/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.whnm.crudTareasProgramadas;

/**
 *
 * @author whnm
 */
public class ProcesoCierre {
    private String codigoProceso;
    private String claseJob;
    private String cronExpresion;
    private String identificacion;

    public ProcesoCierre(String codigoProceso, String claseJob,
            String cronExpresion, String identificacion) {
        this.codigoProceso = codigoProceso;
        this.claseJob = claseJob;
        this.cronExpresion = cronExpresion;
        this.identificacion = identificacion;
    }

    public String getCodigoProceso() {
        return codigoProceso;
    }

    public void setCodigoProceso(String codigoProceso) {
        this.codigoProceso = codigoProceso;
    }

    public String getClaseJob() {
        return claseJob;
    }

    public void setClaseJob(String claseJob) {
        this.claseJob = claseJob;
    }

    public String getCronExpresion() {
        return cronExpresion;
    }

    public void setCronExpresion(String cronExpresion) {
        this.cronExpresion = cronExpresion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    
    
    
    
}
