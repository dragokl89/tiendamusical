/**
 * 
 */
package com.devpredator.tiendamusicalweb.paypal;

import com.paypal.core.PayPalEnvironment;
import com.paypal.core.PayPalHttpClient;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Iterator;

/**
 * @author c-ado 
 * Clase cliente de paypal que configura las clases necesarias
 *         para realizar las transacciones a PayPal y tambien el cliente id y
 *         secret id de acceso  a las aplicaciones SandBox
 */
public class PayPalClient {

	/**
	 * Set up the PayPal Java SDK environment with PayPal access credentials. This
	 * sample uses SandboxEnvironment. In production, use LiveEnvironment.
	 */
	private PayPalEnvironment environment = new PayPalEnvironment.Sandbox("AZKa81NwZN6Ny9zCAFy8mAVX72E3L1A3hK6piRU6JBmb3PS8fV5TrYTP1cCtzcOJFEQvuhXIUrRgDZa_",
			"EAkVn9gFlwdiCXVsrey-jLKVwed0RiNMCN5ra5BKxmehN62KciBPrC2PjivrOrOyAryfMbmB1Z2VcluW");

	/**
	 * PayPal HTTP client instance with environment that has access credentials
	 * context. Use to invoke PayPal APIs.
	 */
	PayPalHttpClient client = new PayPalHttpClient(environment);

	/**
	 * Method to get client object
	 *
	 * @return PayPalHttpClient client
	 */
	public PayPalHttpClient client() {
		return this.client;
	}
}
