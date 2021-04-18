package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;

@RestController
public class ClientController {

	@Autowired
	private WebClient client;
	private String result;
	
	@GetMapping(path = "/client/invoices")
	public String getAllInvoices() {
		
		Flux<String> responseFlux = client.get().uri("http://localhost:6060/api/v1/invoices").retrieve().bodyToFlux(String.class);
		
		responseFlux.subscribe(resp -> this.result = resp);
		
		return result;
		
//		return client.get().uri("http://localhost:6060/api/v1/invoices").retrieve().bodyToFlux(String.class).blockFirst();
	}
	
	@GetMapping(path = "/client/flux/invoices")
	public Flux<String> getAllInvoicesAsFlux() {
		
		return  client.get().uri("http://localhost:6060/api/v1/invoices").retrieve().bodyToFlux(String.class);
//		
//		responseFlux.subscribe(resp -> this.result = resp);
//		
//		return result;
	}
}
