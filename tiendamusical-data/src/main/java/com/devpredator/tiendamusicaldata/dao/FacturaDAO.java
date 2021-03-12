/**
 * 
 */
package com.devpredator.tiendamusicaldata.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.devpredator.tiendamusicalentities.entities.Factura;

/**
 * @author c-ado
 *interfaz que define los metodos para ejecutar el crud de la tabla factura
 */
public interface FacturaDAO extends PagingAndSortingRepository<Factura,Long>{

}
