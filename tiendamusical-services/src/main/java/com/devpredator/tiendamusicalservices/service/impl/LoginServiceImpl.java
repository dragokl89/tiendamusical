/**
 * 
 */
package com.devpredator.tiendamusicalservices.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devpredator.tiendamusicaldata.dao.PersonaDAO;
import com.devpredator.tiendamusicalentities.entities.Persona;
import com.devpredator.tiendamusicalservices.service.LoginService;

/**
 * @author c-ado
 *Clase que implementa las funciones para la logica de negocio para la pantalla de lgoin
 */
@Service
public class LoginServiceImpl implements LoginService {
	@Autowired 
	private PersonaDAO personaDAOimpl;
	@Override
	public Persona consultarUsuarioLogin(String usuario, String password) {
		// TODO Auto-generated method stub
		return this.personaDAOimpl.findByUsuarioAndPassword(usuario, password);
	}

}
