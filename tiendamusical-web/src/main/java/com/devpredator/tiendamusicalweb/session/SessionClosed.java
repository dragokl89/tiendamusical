/**
 * 
 */
package com.devpredator.tiendamusicalweb.session;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.devpredator.tiendamusicalservices.service.LoginService;
import com.devpredator.tiendamusicalweb.utils.CommonUtils;

/**
 * @author c-ado
 *Clase que permite cerrar la sesion del usuario y redireccionar a la pantalla del login
 */
@ManagedBean(name = "sessionClosed")
@ViewScoped
public class SessionClosed {

	/**
	 * metodo que permite cerrar cesion
	 */
	public void cerrarSesion(){
		try {
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			CommonUtils.redireccionar("/login.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_ERROR,"Lo sentimos ","Ocurrio un problema al dirigirse al login");
		}
	}
}
