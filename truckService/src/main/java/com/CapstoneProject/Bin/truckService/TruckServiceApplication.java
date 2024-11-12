package com.CapstoneProject.Bin.truckService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class TruckServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TruckServiceApplication.class, args);
	}

}
