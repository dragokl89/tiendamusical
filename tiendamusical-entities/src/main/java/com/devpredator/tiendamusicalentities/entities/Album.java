/**
 * 
 */
package com.devpredator.tiendamusicalentities.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author c-ado
 *
 */
@Entity
@Table(name  ="album")
public class Album {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column
	private Long idAlbum;
	
	@Column(length = 100 ,nullable= false)
	private String nombre ;
	
	@Column(length = 100 ,nullable= false)
	private String imagen ;
	
	@Column(nullable= false)
	private String descripcion ;
	
	@Column(nullable= false)
	private int anio ;
	
	@Column(length = 10 ,nullable= false)
	private String formato ;
	
	@Column(nullable= false)
	private double valor ;
	
	@ManyToOne
	@JoinColumn(name ="idDisquera")
	private Disquera disquera ;
	
	
	@ManyToOne
	@JoinColumn(name ="idArtista")
	private Artista artista;
	
	@Column
	private Integer raiting ;

	/**
	 * @return the idAlbum
	 */
	public Long getIdAlbum() {
		return idAlbum;
	}

	/**
	 * @param idAlbum the idAlbum to set
	 */
	public void setIdAlbum(Long idAlbum) {
		this.idAlbum = idAlbum;
	}

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
	 * @return the imagen
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * @param imagen the imagen to set
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the anio
	 */
	public int getAnio() {
		return anio;
	}

	/**
	 * @param anio the anio to set
	 */
	public void setAnio(int anio) {
		this.anio = anio;
	}

	/**
	 * @return the formato
	 */
	public String getFormato() {
		return formato;
	}

	/**
	 * @param formato the formato to set
	 */
	public void setFormato(String formato) {
		this.formato = formato;
	}

	/**
	 * @return the valor
	 */
	public double getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}

	/**
	 * @return the disquera
	 */
	public Disquera getDisquera() {
		return disquera;
	}

	/**
	 * @param disquera the disquera to set
	 */
	public void setDisquera(Disquera disquera) {
		this.disquera = disquera;
	}

	/**
	 * @return the artista
	 */
	public Artista getArtista() {
		return artista;
	}

	/**
	 * @param artista the artista to set
	 */
	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	/**
	 * @return the raiting
	 */
	public Integer getRaiting() {
		return raiting;
	}

	/**
	 * @param raiting the raiting to set
	 */
	public void setRaiting(Integer raiting) {
		this.raiting = raiting;
	}
}
