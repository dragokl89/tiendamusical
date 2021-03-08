/**
 * 
 */
package com.devpredator.tiendamusicalweb.controllers;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.devpredator.tiendamusicalweb.utils.CommonUtils;

/**
 * @author c-ado Controlador que se encargad del flujo de datos y acciones de la
 *         barra de navegacion
 */
@ManagedBean(name = "navBarController")
@ViewScoped
public class NavBarController {
	private static final Logger LOGGER = LogManager.getLogger(NavBarController.class);
	/**
	 * Inicializando la pantalla del carrito
	 */
	@PostConstruct
	public void init() {
		LOGGER.info("inicializando pantlla del carrito");
	}
	/**
	 * Metodo que permite redireccionar a la pantalla del carrito de compras
	 */
	public void redireccionar() {
		try {
			CommonUtils.redireccionar("/pages/cliente/carrito.xhtml");
		} catch (IOException e) {
			CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "Lo sentimos", "Ocurrio un problema al ingresar a tu carrito , intente más tarde");
			e.printStackTrace();
		}
	}

}
