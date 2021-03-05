/**
 * 
 */
package com.devpredator.tiendamusicalweb.session;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.devpredator.tiendamusicalentities.entities.Persona;

/**
 * @author c-ado
 *
 */
@ManagedBean(name = "sessionBean")
@SessionScoped
public class SessionBean {
	/**
	 * Objeto persona que se mantendra en sesion
	 */
	private Persona persona ;
	
	@PostConstruct
	public void init() {
		System.out.println("Creando sesion");
	}

	/**
	 * @return the persona
	 */
	public Persona getPersona() {
		return persona;
	}

	/**
	 * @param persona the persona to set
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
}
