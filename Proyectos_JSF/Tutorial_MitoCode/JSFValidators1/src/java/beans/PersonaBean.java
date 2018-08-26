/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import clases.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

/**
 *
 * @author whnm
 */
@ManagedBean
@RequestScoped
public class PersonaBean {
    private Persona persona = new Persona();
    private static List<Persona> listPersonas = new ArrayList<>();
    /**
     * Creates a new instance of PersonaBean
     */
    public PersonaBean() {
     
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Persona> getListPersonas() {
        return listPersonas;
    }

    public void setListPersonas(List<Persona> listPersonas) {
        PersonaBean.listPersonas = listPersonas;
    }
    
    public void registrarPersona(){
        Persona p = new Persona(persona.getNombre(), persona.getSexo(), persona.getEdad());
        listPersonas.add(p);
        persona.setNombre("");
        persona.setSexo("");
        persona.setEdad(2);
    }
    
    public void validar(FacesContext context, UIComponent toValidate,
            Object value){
        context = FacesContext.getCurrentInstance();
        String texto = (String)value;
        
        if(!texto.equalsIgnoreCase("M") && !texto.equalsIgnoreCase("F")){
            ((UIInput)toValidate).setValid(false);
            context.addMessage(toValidate.getClientId(context), new FacesMessage("Sexo no valido"));
        }
    }
    
    public void eliminarPersona(Persona p){
        listPersonas.remove(p);
    }
    
}
