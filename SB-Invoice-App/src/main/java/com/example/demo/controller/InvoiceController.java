package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Invoice;
import com.example.demo.service.InvoiceService;

@RestController
@RequestMapping(value = "/api/v1")
public class InvoiceController {

	
	private InvoiceService invoiceService;

	public InvoiceController(InvoiceService invoiceService) {
		super();
		this.invoiceService = invoiceService;
	}
	
	@GetMapping(path = "/invoices")
	public List<Invoice> findAll(){
		return invoiceService.findAll();
	}
	
	@GetMapping(path = "/invoices/{id}")
	public Invoice findById(@PathVariable("id") int id) {
		return invoiceService.findById(id);
	}
}
