package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

@SpringBootApplication
public class CustomerServiceHateosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceHateosApplication.class, args);
	}
	
	// Command Line to insert rows in Customer table while starting app
	@Bean
	public CommandLineRunner runner() {
		
		return new CommandLineRunner() {
			
			@Autowired
			CustomerRepository repo;
			@Override
			public void run(String... args) throws Exception {
		
				repo.save(new Customer(1,"John",112233));
				repo.save(new Customer(2,"Harry",889900));
				
			}
		};
	}

}
