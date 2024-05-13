package com.viewnext.tarifamicro.presentation.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viewnext.tarifamicro.buisness.service.TerminalService;
import com.viewnext.tarifamicro.buisness.service.TerminalServiceImpl;
import com.viewnext.tarifamicro.model.Terminal;


/**
 * Controller de los terminales, se accede con: " localhost:8081/terminales "
 */
@RestController
@RequestMapping("/terminales")
public class TerminalController {
	
	private static final Logger log = LoggerFactory.getLogger(TerminalController.class);
	
	private TerminalService terminalService = new TerminalServiceImpl();
	
	/**
	 * Peticion get del controller para obtener todo el catalogo de terminales con sus tarifas, se accede con: " localhost:8081/terminales/getTarifas "
	 * 
	 * @return los valores
	 */
	@PostMapping(value = "/getTarifas")
	public List<Terminal> getTarifas(@RequestBody List<Terminal> terminales){
		log.info("Acceso a /getTarifas");
		
		terminalService.adjuntarTarifa(terminales);
		return terminales;
	}
}
