package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Patient;
import com.example.demo.repos.PatientRepository;

@RestController
@RequestMapping(value = "/api/v1")
public class PatientController {
	
	@Autowired
	private PatientRepository patientRepository;

	@GetMapping(path = "/patients")
	public List<Patient> getAllPatients(){
		
		return patientRepository.findAll(); 
	}
	
	@GetMapping(path = "/patients/{id}")
	public Patient getPatientById(@PathVariable(name = "id") int id){
		
		return patientRepository.findById(id).get();
		
	}
}
