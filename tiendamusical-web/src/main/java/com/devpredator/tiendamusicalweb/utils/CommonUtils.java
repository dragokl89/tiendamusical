/**
 * 
 */
package com.devpredator.tiendamusicalweb.utils;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 * @author c-ado Clase generada para generar funcones globales o comunes entre
 *         clases del proyecto
 */
public class CommonUtils {
	/**
	 * Metodo que permite mostrar un mensaje al usuario
	 * 
	 * @param severity {@link Severity} objeto que indica el tipo de mensaje a
	 *                 mostrar
	 * @param summary  {@link String} titulo del mensaje
	 * @param detail   {@link String} detalle del mensaje
	 */
	public static void mostrarMensaje(Severity severity, String summary, String detail) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
	}
	/**
	 * Metodo que permite redireccionar entre pantallas del aplicativo
	 * @param url {@link String} direccion o pantalla a cambiar
	 * @throws IOException {@link IOException} excepcion si es que sucede un error al encontrar la pagina
	 */
	public  static void redireccionar(String url ) throws IOException {
		ExternalContext externalContext =FacesContext.getCurrentInstance().getExternalContext();
		String contextPath = externalContext.getRequestContextPath();
		externalContext.redirect(contextPath+url);
	}
}
