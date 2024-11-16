package com.CapstoneProject.Bin.routeService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
@EnableMongoRepositories
public class RouteServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RouteServiceApplication.class, args);
	}

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}

