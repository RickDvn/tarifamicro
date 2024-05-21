package com.viewnext.tarifamicro.buisness.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.viewnext.tarifamicro.feign.client.TerminalClienteRest;
import com.viewnext.tarifamicro.model.Terminal;
import com.viewnext.tarifamicro.reader.TerminalReader;

@Service
@Primary
public class TerminalClienteRestImpl implements TerminalService {

	private Map<Integer, Terminal> mapTerminales;
	
	@Autowired
	private TerminalClienteRest clienteFeign;
	
	public TerminalClienteRestImpl() {
		this.mapTerminales = new HashMap<>();
	}

	@Override
	public List<Terminal> adjuntarTarifa(List<Terminal> terminales) {
		TerminalReader.adjuntarTarifas(clienteFeign.getTerminales()).stream().forEach(t -> mapTerminales.put(t.getId(), t));
		
		return new ArrayList<>(mapTerminales.values());
	}

	@Override
	public Terminal getbyId(int id) {
		return mapTerminales.get(id);
	}

}
