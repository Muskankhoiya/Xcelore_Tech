package com.nagarro.accountservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class AccountserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountserviceApplication.class, args);
	}
	
	@Bean
	public WebClient webClient() {
		return WebClient.builder().build();
	}

}
