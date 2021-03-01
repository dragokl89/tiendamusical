/**
 * 
 */
package com.devpredator.tiendamusicalentities.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author c-ado
 *Clase que contiene entitdades de perfiles de usuario
 */
@Entity
@Table(name="rol")
public class Rol extends Common{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long idRol;
	
	
	
	@Column(length = 45 ,nullable = false)
	private String nombre;
	
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @param idRol the idRol to set
	 */
	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}
	/**
	 * @return the idRol
	 */
	public Long getIdRol() {
		return idRol;
	}
}
