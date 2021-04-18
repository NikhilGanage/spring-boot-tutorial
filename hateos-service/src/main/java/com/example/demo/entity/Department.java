package com.example.demo.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "department")
public class Department {
	
	@Id
	long id;
	
	String departmentName;
	
	@OneToMany(targetEntity = Employee.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 @JoinColumn(name = "deptId" , referencedColumnName = "id")
	Set<Employee> employees;

}
