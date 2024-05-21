package com.viewnext.tarifamicro.presentation.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viewnext.tarifamicro.buisness.service.TerminalService;
import com.viewnext.tarifamicro.buisness.service.TerminalServiceImpl;
import com.viewnext.tarifamicro.model.Terminal;
import org.springframework.web.bind.annotation.RequestParam;



/**
 * Controller de los terminales, se accede con: " localhost:8081/terminales "
 */
@RestController
@RequestMapping("/terminales")
public class TerminalController {
	
	private static final Logger log = LoggerFactory.getLogger(TerminalController.class);
	
	@Autowired
	private TerminalService terminalService;
	
	/**
	 * Peticion get del controller para obtener todo el catalogo de terminales con sus tarifas, se accede con: " localhost:8081/terminales/getTarifas "
	 * 
	 * @return los valores
	 */
	@PostMapping(value = "/getTarifas")
	public List<Terminal> getTarifas(@RequestBody List<Terminal> terminales){
		List<Terminal> terminalesTemp;
		log.info("Acceso a /getTarifas");
		
		terminalesTemp = terminalService.adjuntarTarifa(terminales);
		return terminalesTemp;
	}

	/**
	 * Peticion get del controller para obtener el terminal con la id pasada con su tarifa, se accede con: " localhost:8081/terminales/getTarifas/ "<- la id deseada
	 * 
	 * @param id, la id del terminal a devolver
	 * @return el terminal con la id deseada
	 */
	@GetMapping(value = "/getTarifas/{id}")
	public Terminal getTarifas(@PathVariable(required = true) int id){
		log.info("Acceso a /getTarifas/{}", id);
		return terminalService.getbyId(id);
	}
	
}
