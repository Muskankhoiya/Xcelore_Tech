package com.nagarro.customerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class CustomerserviceApplication {

    public static void main(String[] args) {
        // Run the Spring Boot application
        SpringApplication.run(CustomerserviceApplication.class, args);
    }

    // Bean definition for WebClient
    @Bean
    public WebClient webClient() {
        // Create and configure a WebClient instance
        return WebClient.builder().build();
    }
}
