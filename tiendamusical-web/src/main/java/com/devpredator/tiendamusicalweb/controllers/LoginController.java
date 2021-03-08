/**
 * 
 */
package com.devpredator.tiendamusicalweb.controllers;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.devpredator.tiendamusicalentities.entities.CarritoAlbum;
import com.devpredator.tiendamusicalentities.entities.Persona;
import com.devpredator.tiendamusicalservices.service.LoginService;
import com.devpredator.tiendamusicalweb.session.SessionBean;
import com.devpredator.tiendamusicalweb.utils.CommonUtils;

/**
 * @author c-ado Controlador que se encarga del flujo de la pantalla login.xhtml
 */
@ManagedBean(name = "login")
@ViewScoped
public class LoginController {
	
	private static final Logger LOGGER = LogManager.getLogger(HomeController.class);
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

	@ManagedProperty("#{sessionBean}")
	private SessionBean sessionBean;

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
			try {
				List<CarritoAlbum> carritoAlbumFiltrados = personaConsultada.getCarrito().getCarritosAlbum().stream()
						.filter(ca -> ca.getEstatus().equals("pendiente")).collect(Collectors.toList());
				
				personaConsultada.getCarrito().setCarritosAlbum(carritoAlbumFiltrados);
				
				LOGGER.info("ALbums del carrito filtrado" );
				
				this.sessionBean.setPersona(personaConsultada);
				
				CommonUtils.redireccionar("/pages/commons/dashboard.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_FATAL, "Fallo",
						"Formato incorrecto con cual se ingresa a la pagina");
			}
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

	/**
	 * @return the sessionBean
	 */
	public SessionBean getSessionBean() {
		return sessionBean;
	}

	/**
	 * @param sessionBean the sessionBean to set
	 */
	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}
}
