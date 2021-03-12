/**
 * 
 */
package com.devpredator.tiendamusicalservices.service;

import java.util.List;

import com.devpredator.tiendamusicalentities.dto.ArtistaAlbumDTO;
import com.devpredator.tiendamusicalentities.entities.Carrito;
import com.devpredator.tiendamusicalentities.entities.CarritoAlbum;
import com.devpredator.tiendamusicalentities.entities.Factura;

/**
 * @author c-ado Interface que define los metodos de logica de negocio para el
 *         carrito de compras
 */
public interface CarritoService {
	/**
	 * Metodo que permite guardar los album a comprar en el carrito de compras
	 * 
	 * @param artistaAlbumDTO           {@link ArtistaAlbumDTO} objeto con la
	 *                                  informacion del album en el carrito
	 * @param carrito                   {@link Carrito} objeto con la informacion
	 *                                  del carrito del usuario
	 * @param cantidadAlbumSeleccionada {@link Integer} cantidad selecciondad de
	 *                                  albums por el usuarios
	 */
	CarritoAlbum guardarAlbumsCarritoDTO(ArtistaAlbumDTO artistaAlbumDTO, Carrito carrito,
			int cantidadAlbumSeleccionada);

	/**
	 * Metodo que permite calcular el total de la compra
	 * 
	 * @param carrito {@link Carrito} objeto carrito con la informacion a calcular
	 * @return {@link Float} total de la compra calculada
	 */
	float calcularTotal(Carrito carrito);

	/**
	 * metodo que permite eliminar un album del carrito
	 * 
	 * @param carritoAlbum {@link} album a eliminar
	 */
	void eliminarAlbumCarrito(CarritoAlbum carritoAlbum);

	/**
	 * metodo que permite actulizar la cantidad de albums del carrito
	 * 
	 * @param carritoAlbum {@link CarritoAlbum} album a actualizar en el carrito
	 * @param carrito      {@link Carrito} carrito de compra del usuario
	 */
	float actualizarAlbumCantidad(CarritoAlbum carritoAlbum, Carrito carrito);

	/**
	 * Metodo que permite actualizar los registros de los productos comprados por el
	 * cliente agregandoles la orden de compra y actualizando su estatus a PAGADO.
	 * 
	 * @param carritoAlbums {@link List} lista de productos en el carrito a
	 *                      actualizar.
	 * @param factura       {@link Factura} objeto con la factura y la orden de
	 *                      compra.
	 * @return {@link Boolean} estatus de la actualizacion del carrito.
	 */
	boolean actualizarCarritoAlbum(List<CarritoAlbum> carritoAlbums, Factura factura);
}
