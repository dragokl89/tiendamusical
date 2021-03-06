package com.devpredator.tiendamusicaldata.dao.impl;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.devpredator.tiendamusicaldata.common.CommonDAO;
import com.devpredator.tiendamusicaldata.dao.ArtistaDAO;
import com.devpredator.tiendamusicalentities.dto.ArtistaAlbumDTO;
import com.devpredator.tiendamusicalentities.entities.Artista;
/**
 * 
 * @author c-ado
 *Clase que representa el DAO para  el CRUD hacia la tabla Artista
 */
public class ArtistaDAOImpl extends CommonDAO<Artista,ArtistaDAO> {
	public List<ArtistaAlbumDTO> consultarArtistasAlbumsPorFiltros( String filtro){
		return this.repository.consultarArtistasAlbumsPorFiltros(filtro);
	}
}
