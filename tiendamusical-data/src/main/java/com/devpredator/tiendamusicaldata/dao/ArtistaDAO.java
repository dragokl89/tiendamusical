package com.devpredator.tiendamusicaldata.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.devpredator.tiendamusicalentities.dto.ArtistaAlbumDTO;
import com.devpredator.tiendamusicalentities.entities.Artista;
/**
 * 
 * @author c-ado
 *Clase que representa el DAO para el CRUD  hacia la tabla de Artistas
 */
public interface ArtistaDAO extends PagingAndSortingRepository<Artista,Long> {
	
@Query("SELECT new com.devpredator.tiendamusicalentities.dto.ArtistaAlbumDTO(a, ar )"
		+ "FROM Album a "
		+ "INNER JOIN a.artista ar "
		+ "INNER JOIN ar.subGenero sg "
		+ "INNER JOIN sg.genero g "
		+"WHERE ar.nombre LIKE %:filtro% "
		+"OR g.descripcion LIKE %:filtro% "
		+"OR sg.descripcion LIKE %:filtro% "
		+"OR a.nombre LIKE %:filtro% "
		+"ORDER BY ar.nombre ")
	public List<ArtistaAlbumDTO> consultarArtistasAlbumsPorFiltros(@Param("filtro") String filtro);
}
