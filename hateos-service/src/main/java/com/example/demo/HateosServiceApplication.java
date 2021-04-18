package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Department;
import com.example.demo.entity.Doctor;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Patient;
import com.example.demo.repos.DepartmentRepository;
import com.example.demo.repos.DoctorRepository;

@SpringBootApplication
public class HateosServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HateosServiceApplication.class, args);

	}
	
	@Bean
	public CommandLineRunner runner() {
		
		return new CommandLineRunner() {
			
			@Autowired
			DoctorRepository doctorRepository;
			
			@Autowired
			DepartmentRepository departmentRepository;
			
			@Override
			public void run(String... args) throws Exception {
				
				Patient hari = new Patient(101, "Hari", "flu");
				Patient gopal = new Patient(201,"Gopal","fever");
				
				HashSet<Patient> patientList = new HashSet<>();
				patientList.add(hari);
				patientList.add(gopal);
				Doctor mahesh = new Doctor(1, "Mahesh", patientList);
				
				
				doctorRepository.save(mahesh);
				
				Employee e1 = new Employee(101,"Sameer",20000.0);
				Employee e2 = new Employee(201,"Rahul",35000.0);
				Employee e3 = new Employee(301,"Shubham",24000.0);
				Employee e4 = new Employee(401,"Ram",38000.0);
				Employee e5 = new Employee(501,"Supriya",23000.0);
				Employee e6 = new Employee(602,"Rutuja",42000);
				
				Set<Employee> itEmployees = new HashSet<>();
				itEmployees.add(e1);
				itEmployees.add(e2);
				itEmployees.add(e3);
				itEmployees.add(e6);
				
				Department it = new Department(1, "IT", itEmployees);
				
				departmentRepository.save(it);
				
				Set<Employee> hrEmployees = new HashSet<>();
				hrEmployees.add(e4);
				hrEmployees.add(e5);
				
				Department hr = new Department(2, "HR", hrEmployees);
				
				departmentRepository.save(hr);			
			}
		};
	}

}
