package com.nequi.franquicias.infraestructura.actuator;

import com.nequi.franquicias.infraestructura.excepcion.ExcepcionTecnica;

/**
 * Interface que tiene por objetivo ser implementada por todos los bloques 
 * que quieran utilizar HealthCheck
 * 
 * @author sergio.villamizar
 *
 */

public interface Salud  {
	/**
	 * Registra los bloques implementados
	 */
	public void registrarBloque();
	
	/**
	 * Valida la salud del bloque
	 * @throws ExcepcionTecnica
	 */
	public void verificar() throws ExcepcionTecnica;//a�adir

}
