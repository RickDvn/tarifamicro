package com.viewnext.tarifamicro.buisness.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.viewnext.tarifamicro.model.Terminal;
import com.viewnext.tarifamicro.reader.TerminalReader;

import lombok.Data;

@Data
/**
 * Implementacion de la interfaz de terminales (TerminalService)
 */
@Service
public class TerminalServiceImpl implements TerminalService {

	Map<Integer, Terminal> terminalRep;
	
	public TerminalServiceImpl() {
		terminalRep = new HashMap<>();
	}
	
	@Override
	public List<Terminal> adjuntarTarifa(List<Terminal> terminales) {
		List<Terminal> terminalesTemp = TerminalReader.adjuntarTarifas(terminales);
		
		for (Terminal terminal : terminalesTemp) {
			if (terminal.getPrecio() != null) {
				terminalRep.put(terminal.getId(), terminal);
			}
		}
		
		return new ArrayList<>(terminalRep.values());
	}

	@Override
	public Terminal getbyId(int id) {
		return terminalRep.get(id);
	}
}
