package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Invoice;
import com.example.demo.repository.InvoiceRepository;

@Service
public class InvoiceService {

	private InvoiceRepository invoiceRepository;

	public InvoiceService(InvoiceRepository invoiceRepository) {
		super();
		this.invoiceRepository = invoiceRepository;
	}
	
	public List<Invoice> findAll(){
		return invoiceRepository.findAll();
	}
	
	public Invoice findById(int id) {
//		return invoiceRepository.findById(id).get();
		
		return invoiceRepository.findById(id).orElseThrow(()-> new RuntimeException("Given Id is not present"));
	}
}
