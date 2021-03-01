/**
 * 
 */
package com.devpredator.tiendamusicalweb.controllers;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.devpredator.tiendamusicalentities.entities.Persona;
import com.devpredator.tiendamusicalservices.service.LoginService;
import com.devpredator.tiendamusicalweb.utils.CommonUtils;

/**
 * @author c-ado Controlador que se encarga del flujo de la pantalla login.xhtml
 */
@ManagedBean(name = "login")
@ViewScoped
public class LoginController {
	/**
	 * Usuario capturado por la persona
	 */
	private String usuario;
	/**
	 * Password capturado por la persona
	 */
	private String password;
	/**
	 * Propieda de la logica de negocio inyectada con JSF
	 */
	@ManagedProperty("#{loginServiceImpl}")
    private LoginService loginServiceImpl;
	
	@PostConstruct
	public void init() {
		System.out.println("Inicializando login");
	}

	/**
	 * metodo que permite ingresar a la ventana home
	 */
	public void ingresar() {
		
		Persona personaConsultada = this.loginServiceImpl.consultarUsuarioLogin(this.usuario, this.password);
		if (personaConsultada != null) {
			CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_INFO, "Exito", "Bienvenido a home");
		} else {
			CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "Fallo",
					"El usuario y/o contraseña son incorrectos");
		}
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the loginServiceImpl
	 */
	public LoginService getLoginServiceImpl() {
		return loginServiceImpl;
	}

	/**
	 * @param loginServiceImpl the loginServiceImpl to set
	 */
	public void setLoginServiceImpl(LoginService loginServiceImpl) {
		this.loginServiceImpl = loginServiceImpl;
	}
}
