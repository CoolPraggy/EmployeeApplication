package com.accolite.testApp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.accolite.testApp.model.Employee;
import com.accolite.testApp.repo.EmployeeRepository;
import com.accolite.testApp.service.EmployeeService;

@SpringBootTest
class TestAppApplicationTests {
	
	@Autowired
	private EmployeeService employeeService;
	
	@MockBean
	private EmployeeRepository employeeRepository;

	@Test
	public void getAllEmployeeTest() {
		when(employeeRepository.findAll()).thenReturn(Stream.of(new Employee(1,"Pragati","pragati.arora@accolitedigital.com"),
				new Employee(2,"Raj","raj.arora@accolitedigital.com")).collect(Collectors.toList()));
		assertEquals(2, employeeService.getAllEmployee().size());			
	}
	
	@Test
	public void getEmployeeById() {
		long id = 1;
		Employee employee = new Employee(1,"Pragati","pragati.arora@accolitedigital.com");
		when(employeeRepository.findById(id)).thenReturn(employee);
		assertEquals(employeeService.getEmployeeById(id), employeeRepository.findById(id));
	}
	
	@Test
	public void getEmployeeByEmail() {
		String email = "raj.arora@accolitedigital.com";
		Employee employee = new Employee(1,"Raj","raj.arora@accolitedigital.com");
		when(employeeRepository.findByEmail(email)).thenReturn(employee);
		assertEquals(employeeService.getEmployeeByEmail(email), employeeRepository.findByEmail(email));
	}
	
	@Test
	public void saveEmployee() {
		Employee employee = new Employee(1,"Shubh","shubh.arora@accolitedigital.com");
		when(employeeRepository.save(employee)).thenReturn(employee);
		assertEquals(employee,employeeRepository.save(employee));
	}
}
