package com.viewnext.tarifamicro.feign.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.viewnext.tarifamicro.model.Terminal;

/**
 * Clase que contiene todas las llamadas al micro: batch-micro
 */
@FeignClient(name = "batch-micro")
public interface TerminalClienteRest {

	/**
	 * Llama al endpoint /terminales/getCatalogo de batch-micro para obtener la lista de
	 * terminales
	 * 
	 * @return List<Terminal>
	 */
	@GetMapping(value = "/terminales/getCatalogo")
	public List<Terminal> getTerminales();
	
}
