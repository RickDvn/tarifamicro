package com.viewnext.tarifamicro.buisness.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.viewnext.tarifamicro.model.Terminal;
import com.viewnext.tarifamicro.reader.TerminalReader;


/**
 * Implementacion de la interfaz de terminales (TerminalService)
 */
@Service
public class TerminalServiceImpl implements TerminalService {

	@Override
	public List<Terminal> adjuntarTarifa(List<Terminal> terminales) {
		return TerminalReader.adjuntarTarifas(terminales);
	}

}
