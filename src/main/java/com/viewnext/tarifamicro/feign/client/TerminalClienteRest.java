package com.viewnext.tarifamicro.feign.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.viewnext.tarifamicro.model.Terminal;

@FeignClient(name = "batch-micro")
public interface TerminalClienteRest {

	@GetMapping(value = "/terminales/getCatalogo")
	public List<Terminal> getTerminales();
	
}
