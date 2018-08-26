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
    
    public void agregarPersona(){
        Persona p = new Persona(persona.getNombre(), persona.getApellido(), persona.getSexo());
        listPersonas.add(p);
        persona.setNombre("");
        persona.setApellido("");
        persona.setSexo("");
    }
    
    public void eliminarPersona(Persona p){
        listPersonas.remove(p);
    }
    
}
