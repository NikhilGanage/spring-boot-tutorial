package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.example.demo.config.ApplicationConfig;
import com.example.demo.model.Customer;
import com.example.demo.model.Invoice;
import com.example.demo.model.OrderBook;
import com.example.demo.model.Product;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class ProductServiceApplication {
	
	@Autowired
	private ApplicationConfig  config;

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ProductServiceApplication.class, args);
		
		Product tv = context.getBean("tv",Product.class);
		
		log.info(tv.toString());
		
//		Customer cust = context.getBean(Customer.class);
//		
//		log.info(cust.toString());
		
//		Invoice invoice = context.getBean("rameshInvoice",Invoice.class);
//		
//		log.info(invoice.toString());
		
		Product fridge = context.getBean("fridge", Product.class);
		
		log.info(fridge.toString());
		
//		Invoice invoice1 = context.getBean("rameshSecondInvoice",Invoice.class);
//		
//		log.info(invoice1.toString());
		
		Invoice sureshInvoice = context.getBean("sureshInvoice",Invoice.class);
		
		log.info(sureshInvoice.toString());
		
		log.info("IoC Container -Reference"+context.getClass().getName());
		
		OrderBook orderBook = context.getBean(OrderBook.class);
		
		orderBook.getInvoiceList().forEach(System.out:: println);
		
//		context.close();
		
	}

	@Bean
	public Product tv() {
		return new Product(101, "Sony TV", 35000.0);
	}
	
	@Bean
	@Primary
	public Product fridge() {
		return new Product(201, "Samsung Double Door", 21000.0);
	}
	
	
	@Bean
	public Customer customer() {
		return new Customer(1, "Ramesh");
	}
	
	@Bean 
	public Invoice rameshInvoice() {
		return new Invoice(customer(),tv());
	}
	
	@Bean 
	public Invoice rameshSecondInvoice() {
		return new Invoice(customer(),fridge());
	}
	
	@Bean
	public Invoice sureshInvoice(@Qualifier("suresh") Customer customer,@Qualifier("printer") Product product) {
		return new Invoice(customer,product);
	}
	
	
	
}
