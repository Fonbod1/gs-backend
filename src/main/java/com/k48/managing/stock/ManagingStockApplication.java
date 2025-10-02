package com.k48.managing.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ManagingStockApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagingStockApplication.class, args);
	}

}
