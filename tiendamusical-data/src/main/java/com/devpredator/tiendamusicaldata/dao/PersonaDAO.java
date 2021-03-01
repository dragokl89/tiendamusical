/**
 * 
 */
package com.devpredator.tiendamusicaldata.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.devpredator.tiendamusicalentities.entities.Persona;

/**
 * @author c-ado Clase DAO que realiza el crud con spring jpa para la tabla de
 *         persona
 */
public interface PersonaDAO extends PagingAndSortingRepository<Persona, Long> {
/**
 * Metodo que permite consultar el usuario que trata de ingresar
 * @param usuario {@link String} usuario capturado por la persona
 * @param password {@link String} contraseña capturada por la persona
 * @return {@link Persona} objeto con la persona encontrada
 */
	@Query("SELECT p FROM Persona p WHERE p.usuario =?1 AND p.password =?2" )
	Persona findByUsuarioAndPassword(String usuario ,String password);
}
