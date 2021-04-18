package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Customer;
import com.example.demo.model.Product;

@Configuration
public class ApplicationConfig {

	@Bean
	public Customer suresh() {
		return new Customer(2, "Suresh");
	}
	
	@Bean
	public Customer mahesh() {
		return new Customer(3, "Mahesh");
	}
	
	@Bean
	public Product printer() {
		return new Product(301, "Dell Inkjet", 1800.0);
	}
	
	@Bean
	public Product laptop() {
		return new Product(401,"Macbook Air",80500.0);
	}
	
}
