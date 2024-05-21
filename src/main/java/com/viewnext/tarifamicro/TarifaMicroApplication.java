package com.viewnext.tarifamicro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class TarifaMicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(TarifaMicroApplication.class, args);
	}

}
