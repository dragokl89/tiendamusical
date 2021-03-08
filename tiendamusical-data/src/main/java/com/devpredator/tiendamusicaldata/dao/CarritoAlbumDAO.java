/**
 * 
 */
package com.devpredator.tiendamusicaldata.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.devpredator.tiendamusicalentities.entities.CarritoAlbum;

/**
 * @author c-ado Interfaz que implementa los metodos genericos para el CRUD con
 *         SPRING JPA hacia la tabla carrito
 */
public interface CarritoAlbumDAO extends PagingAndSortingRepository<CarritoAlbum, Long> {

}
