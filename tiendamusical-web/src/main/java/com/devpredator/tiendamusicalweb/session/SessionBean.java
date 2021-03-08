/**
 * 
 */
package com.devpredator.tiendamusicalweb.session;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.devpredator.tiendamusicalentities.dto.ArtistaAlbumDTO;
import com.devpredator.tiendamusicalentities.entities.Persona;

/**
 * @author c-ado
 *
 */
@ManagedBean(name = "sessionBean")
@SessionScoped
public class SessionBean {
	/**
	 * Objeto persona que se mantendra en sesion
	 */
	private Persona persona ;
	/**
	 * Objeto que contendra la informacion del detalle delproducto que el usuario desea ver
	 */
	private ArtistaAlbumDTO artistaAlbumDTO;
	
	/**
	 * Total generado de la compra en sesion 
	 */
    private float totalCompra;
	
	@PostConstruct
	public void init() {
		System.out.println("Creando sesion");
	}

	/**
	 * @return the persona
	 */
	public Persona getPersona() {
		return persona;
	}

	/**
	 * @param persona the persona to set
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	/**
	 * @return the artistaAlbumDTO
	 */
	public ArtistaAlbumDTO getArtistaAlbumDTO() {
		return artistaAlbumDTO;
	}

	/**
	 * @param artistaAlbumDTO the artistaAlbumDTO to set
	 */
	public void setArtistaAlbumDTO(ArtistaAlbumDTO artistaAlbumDTO) {
		this.artistaAlbumDTO = artistaAlbumDTO;
	}

	/**
	 * @return the totalCompra
	 */
	public float getTotalCompra() {
		return totalCompra;
	}

	/**
	 * @param totalCompra the totalCompra to set
	 */
	public void setTotalCompra(float totalCompra) {
		this.totalCompra = totalCompra;
	}



}
