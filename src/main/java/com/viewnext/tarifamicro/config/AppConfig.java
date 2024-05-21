package com.viewnext.tarifamicro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Configuracion para los RestTemplates
 */
@Configuration
public class AppConfig {
	
	/**
	 * Devuelve un nuevo RestTemplate para comunicar a los micros (solo necesario si no se usa Feign)
	 * 
	 * @return RestTemplate
	 */
	@Bean("registrarTemplateTarifas")
	RestTemplate registerRestTemplate() {
		return new RestTemplate();
	}
}
