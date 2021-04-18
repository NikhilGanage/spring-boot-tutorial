package com.example.demo.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Doctor;
import com.example.demo.entity.Patient;
import com.example.demo.repos.DoctorRepository;

@RestController
@RequestMapping(value = "/app/v1")
public class DoctorController {
	
	@Autowired
	private DoctorRepository doctorRepository;

	@GetMapping(path = "/doctors")
	public CollectionModel<Doctor> getAllDoctors(){
		
		List<Doctor> doctorList = doctorRepository.findAll();
		
		for(Doctor doctor : doctorList) {
			Set<Patient> patientList = doctor.getPatients();
			
			for(Patient patient : patientList) {
				Link selfLink = WebMvcLinkBuilder.linkTo(PatientController.class).slash("patients/"+patient.getPatientId()).withSelfRel();
				
				patient.add(selfLink);
			}
			
		}
		
		Link link = WebMvcLinkBuilder.linkTo(DoctorController.class).slash("doctors").withSelfRel();
		
		CollectionModel<Doctor> result = CollectionModel.of(doctorList,link);
		
		return result;
	}
	
}
