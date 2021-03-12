/**
 * 
 */
package com.devpredator.tiendamusicalentities.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author c-ado Clase que tiene los campos comunes
 */
@MappedSuperclass
public class Common {
	@Column(nullable = false)
	private LocalDateTime fechaCreacion;
	
	@Column
	private LocalDateTime fechaModificacion;
	
	@Column(nullable = false)
	private boolean estatus;

	/**
	 * @return the fechaCreacion
	 */
	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * @return the fechaModificacion
	 */
	public LocalDateTime getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(LocalDateTime fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * @return the estatus
	 */
	public boolean isEstatus() {
		return estatus;
	}

	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}
}
