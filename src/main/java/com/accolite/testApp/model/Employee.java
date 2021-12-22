package com.accolite.testApp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column
	@NotBlank(message="EmployeeId cannot be empty")
	private long id ;
	
	@Column
	@NotBlank(message = "EmployeeName cannot be empty")
	private String name ;
	
	@Column
	@NotBlank(message = "EmployeeEmail cannot be empty")
	private String email;

}
