/**
 * 
 */
package com.devpredator.tiendamusicalweb.controllers;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.devpredator.tiendamusicalentities.dto.ArtistaAlbumDTO;
import com.devpredator.tiendamusicalentities.entities.CarritoAlbum;
import com.devpredator.tiendamusicalservices.service.CarritoService;
import com.devpredator.tiendamusicalweb.session.SessionBean;

/**
 * @author c-ado Clase que controla el flujo de datos de la pagina detalle.xhtml
 */
@ManagedBean(name = "detalleController")
@ViewScoped
public class DetalleController {

	private static final Logger LOGGER = LogManager.getLogger(HomeController.class);
	/*
	 * Cantidad del producto seleccionado
	 */
	private int cantidadAlbumSeleccionada;
	/**
	 * Objeto que contiene la logica de negocio del carrito
	 */
	@ManagedProperty("#{carritoServiceImpl}")
	private CarritoService carritoServiceImpl;
	/**
	 * Objeto que contiene informacion del usaurio en sesion
	 */
	@ManagedProperty("#{sessionBean}")
	private SessionBean sessionBean;

	@PostConstruct
	public void init() {
		this.cantidadAlbumSeleccionada = 1;
	}

	/**
	 * Metodo que permite agregar albums al carrito de compra
	 * 
	 * @param artistaAlbumDTO {@link ArtistaAlbumDTO} objto con el album
	 *                        seleccionado
	 */
	public void agregarAlbumCarrito(ArtistaAlbumDTO artistaAlbumDTO) {
		LOGGER.info("Agregando album al carrito de compra" + " , Cantidad :" + this.cantidadAlbumSeleccionada);
		CarritoAlbum carritoAlbumAgreado = this.carritoServiceImpl.guardarAlbumsCarritoDTO(artistaAlbumDTO, this.sessionBean.getPersona().getCarrito(),
				cantidadAlbumSeleccionada);
		this.sessionBean.getPersona().getCarrito().getCarritosAlbum().add(carritoAlbumAgreado);
	}

	/**
	 * @return the cantidadAlbumSeleccionada
	 */
	public int getCantidadAlbumSeleccionada() {
		return cantidadAlbumSeleccionada;
	}

	/**
	 * @param cantidadAlbumSeleccionada the cantidadAlbumSeleccionada to set
	 */
	public void setCantidadAlbumSeleccionada(int cantidadAlbumSeleccionada) {
		this.cantidadAlbumSeleccionada = cantidadAlbumSeleccionada;
	}

	/**
	 * @return the logger
	 */
	public static Logger getLogger() {
		return LOGGER;
	}

	/**
	 * @return the carritoServiceImpl
	 */
	public CarritoService getCarritoServiceImpl() {
		return carritoServiceImpl;
	}

	/**
	 * @param carritoServiceImpl the carritoServiceImpl to set
	 */
	public void setCarritoServiceImpl(CarritoService carritoServiceImpl) {
		this.carritoServiceImpl = carritoServiceImpl;
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
