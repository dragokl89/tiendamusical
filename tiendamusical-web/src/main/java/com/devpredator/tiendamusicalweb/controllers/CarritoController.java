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

import com.devpredator.tiendamusicalentities.entities.CarritoAlbum;
import com.devpredator.tiendamusicalservices.service.CarritoService;
import com.devpredator.tiendamusicalweb.session.SessionBean;

/**
 * @author c-ado Clase que se encarga de controlar el flujo de datos de la
 *         pagina carrito.xhtml
 */
@ManagedBean(name = "carritoController")
@ViewScoped
public class CarritoController {
	private static final Logger LOGGER = LogManager.getLogger(CarritoController.class);
	/**
	 * Objeto que contiene informacion del usuario
	 */
	@ManagedProperty("#{sessionBean}")
	private SessionBean sessionBean;
	/**
	 * Objeto que realiza la logica de negocio del carrito
	 */
	@ManagedProperty("#{carritoServiceImpl}")
	private CarritoService carritoServiceImpl;

	/**
	 * Inicializa la información de la pantalla carrito
	 */
	@PostConstruct
	public void init() {
		this.calcularTotal();
	}

	/**
	 * Metodo que permite calcular el total de la compra del carrito
	 */
	public void calcularTotal() {
		LOGGER.info("Calculando total");
		float total = this.carritoServiceImpl.calcularTotal(this.sessionBean.getPersona().getCarrito());
		this.sessionBean.setTotalCompra(total);
	}

	/**
	 * @return the sessionBean
	 */
	public SessionBean getSessionBean() {
		return sessionBean;
	}

	/**
	 * Meto que permite eliminar un album del carrito
	 * 
	 * @param carritoAlbum {@link CarritoAlbum} objeto a eliminar del carrito
	 */
	public void eliminarAlbumCarrito(CarritoAlbum carritoAlbum) {
		// Se realiza la llamada del carrito de eliminarAlbumCarrito a la data
		LOGGER.info("Eliminando album" + carritoAlbum.getAlbum().getNombre() + "carrito");
		this.carritoServiceImpl.eliminarAlbumCarrito(carritoAlbum);
		this.sessionBean.getPersona().getCarrito().getCarritosAlbum().remove(carritoAlbum);
		this.calcularTotal();
	}

	/**
	 * Metodo que permite actualizar la cantidad y totales de albumn comprados
	 * 
	 * @param carritoAlbum {@link CarritoAlbum } objeto que contiene el album con la
	 *                     informacion a actualizar
	 */
	public void actualizarCantidadCarrito(CarritoAlbum carritoAlbum) {
		float totalCompra = this.carritoServiceImpl.actualizarAlbumCantidad(carritoAlbum,
				this.sessionBean.getPersona().getCarrito());
		this.sessionBean.setTotalCompra(totalCompra);
	}

	/**
	 * @param sessionBean the sessionBean to set
	 */
	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}

	/**
	 * @return the carritoService
	 */
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

}
