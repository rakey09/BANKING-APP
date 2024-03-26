package net.spring.Banking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// This annotation indicates that this class is the main entry point for the Spring Boot application
@SpringBootApplication
public class BankingAppApplication {

	public static void main(String[] args) {
		// This method starts the Spring Boot application
		SpringApplication.run(BankingAppApplication.class, args);
	}

}

