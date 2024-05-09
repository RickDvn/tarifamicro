package com.viewnext.tarifamicro.presentation.service;

import java.util.List;

import com.viewnext.tarifamicro.model.Terminal;

/**
 * Interfac para los Terminales
 */
public interface TerminalService {
	
	/**
	 * Este metodo obtiene todos los terminales de los ficheros CSV y los devuelve
	 * 
	 * @return List<Terminal> los terminales de los ficheros
	 */
	public List<Terminal> getTerminales();
	
	public List<Terminal> adjuntarTarifa(List<Terminal> terminales);
	
}
