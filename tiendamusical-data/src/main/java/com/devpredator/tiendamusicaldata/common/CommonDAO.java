/**
 * 
 */
package com.devpredator.tiendamusicaldata.common;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author c-ado
 *Clase generica que representa los metodos del CRUD que se reutilizan en todas entidad des del proyecto
 *E - significa la entidad a utilizar en el CRUD
 *R - Significa el repositorio a utilizar de JPA para ejecutar el CRUD
 */
public class CommonDAO <E , R extends PagingAndSortingRepository<E, Long>> {
      protected R repository;
      /**
       * Metodo que permite consultar una lista de datos paginables de una entidad
       * @param desde {@link Integer} indica a aprtir de que valor se obtendra los resultados
       * @param hasta {@link Integer} indica el limite de los resultados paginados
       * @param orderBy {@link String} indica a partir de que campo se ordenaran los registros
       * @return {@link List} lista con los datos paginados 
       */
      public List<E> consultarListaPaginable(int desde ,int hasta ,String orderBy){
    	  Pageable pageable = PageRequest.of(desde, hasta,Sort.by(orderBy));
    	  Page<E> page = this.repository.findAll(pageable);
    	  return page.getContent();
      }
      /**
       * Metodo que permite persisistir la informacion de cualquier entiddad
       * @param e {@link Object} objeto o entidad a persistir
       * @return {@link Object} objeto recuperado despues de persistir el registro
       */
      public E guardar(E e) {
    	  return this.repository.save(e);
      }
      
      /**
       * Metodo que permite actualizar la informacion de cualquier entiddad
       * @param e {@link Object} objeto o entidad a actualizar
       * @return {@link Object} objeto recuperado despues de actualizar el registro
       */
      public E actualizar(E e) {
    	  return this.repository.save(e);
      }
      
      /**
       * Metodo que permite eliminar la informacion de cualquier entidad
       * @param e {@link Object} objeto o entidad a persistir
       */
      public void eliminar(E e) {
    	   this.repository.delete(e);;
      }
}
