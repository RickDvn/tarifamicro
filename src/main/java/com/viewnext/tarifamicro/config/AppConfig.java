package com.viewnext.tarifamicro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
	
	@Bean("registrarTemplateTarifas")
	RestTemplate registerRestTemplate() {
		return new RestTemplate();
	}
}
