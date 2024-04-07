package com.labisistemas.gestaofinanceiraapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GestaoFinanceiraApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoFinanceiraApiApplication.class, args);
	}

}
