package com.accolite.testApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.testApp.model.Employee;
import com.accolite.testApp.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public List<Employee> getEmployee(){
		return employeeService.getAllEmployee();
	}

	@GetMapping("id/{id}")
	public Employee getEmployeeById(@PathVariable(value ="id") long employeeId) {
		return employeeService.getEmployeeById(employeeId);	
	}
	
	@GetMapping("email/{email}")
	public Employee getEmployeeByEmail(@PathVariable(value ="email") String employeeEmail) {
		return employeeService.getEmployeeByEmail(employeeEmail);
	}
	
	@PostMapping
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
		
	}
}
