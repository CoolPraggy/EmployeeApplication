package com.accolite.testApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.testApp.model.Employee;
import com.accolite.testApp.repo.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployee(){
		return employeeRepository.findAll();
	}
	
	public Employee getEmployeeById(long employeeId){
		return employeeRepository.findById(employeeId);
	}
	
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public Employee getEmployeeByEmail(String employeeEmail) {
		return employeeRepository.findByEmail(employeeEmail);
	}

}
