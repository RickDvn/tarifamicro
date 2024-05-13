package com.viewnext.tarifamicro.buisness.service;

import java.util.List;

import com.viewnext.tarifamicro.model.Terminal;

/**
 * Interfac para los Terminales
 */
public interface TerminalService {
	
	public List<Terminal> adjuntarTarifa(List<Terminal> terminales);
	
}
