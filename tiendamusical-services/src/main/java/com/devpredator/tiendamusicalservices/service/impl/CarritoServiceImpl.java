/**
 * 
 */
package com.devpredator.tiendamusicalservices.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devpredator.tiendamusicaldata.dao.CarritoAlbumDAO;
import com.devpredator.tiendamusicalentities.dto.ArtistaAlbumDTO;
import com.devpredator.tiendamusicalentities.entities.Carrito;
import com.devpredator.tiendamusicalentities.entities.CarritoAlbum;
import com.devpredator.tiendamusicalservices.service.CarritoService;

/**
 * @author c-ado Clase que implementa los metodos de la logica de negocio de
 *         CarritoService para el carrito de compra
 */
@Service
public class CarritoServiceImpl implements CarritoService {

	@Autowired
	private CarritoAlbumDAO carritoAlbumDAO;

	@Override
	public CarritoAlbum guardarAlbumsCarritoDTO(ArtistaAlbumDTO artistaAlbumDTO, Carrito carrito, int cantidadAlbumSeleccionada) {
		CarritoAlbum carritoAlbum = new CarritoAlbum();
		carritoAlbum.setAlbum(artistaAlbumDTO.getAlbum());
		carritoAlbum.setCarrito(carrito);
		carritoAlbum.setCantidad(cantidadAlbumSeleccionada);
		carritoAlbum.setEstatus("pendiente");
		this.carritoAlbumDAO.save(carritoAlbum);
		return carritoAlbum;
	}

	@Override
	public float calcularTotal(Carrito carrito) {
		// TODO Auto-generated method stub
		float total= 0.0F;
		//	Se realiza el calculo
		for (CarritoAlbum ca : carrito.getCarritosAlbum()) {
			total +=(ca.getAlbum().getValor()*ca.getCantidad());
		}
		return total;
	
	}

	@Override
	public void eliminarAlbumCarrito(CarritoAlbum carritoAlbum) {
		// TODO Auto-generated method stub
		this.carritoAlbumDAO.delete(carritoAlbum);
	}

	@Override
	public float actualizarAlbumCantidad(CarritoAlbum carritoAlbum ,Carrito carrito) {
		// TODO Auto-generated method stub
	    this.carritoAlbumDAO.save(carritoAlbum);
	    return this.calcularTotal(carrito);
	}

}
