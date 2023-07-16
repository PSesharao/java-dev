package com.mindtree.restapp.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class EmployeeDto {
	@NotEmpty(message = "first name must not be empty")
	private String firstName;
	@NotEmpty(message = "last name must not be empty")
	private String lastName;
	@NotEmpty(message = "designation must not be empty")
	private String designation;
	// @NotEmpty(message = "salary must not be empty and must be postive")
	@DecimalMin(value = "1.00", message = "salary must be positive")
	private double salary;
	@NotEmpty(message = "email must not be empty")
	@Email(message = "email should be a valid email")
	private String email;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public EmployeeDto() {

	}

	public EmployeeDto(@NotEmpty(message = "first name must not be empty") String firstName,
			@NotEmpty(message = "last name must not be empty") String lastName,
			@NotEmpty(message = "designation must not be empty") String designation,
			@DecimalMin(value = "1.00", message = "salary must be positive") double salary,
			@NotEmpty(message = "email must not be empty") @Email(message = "email should be a valid email") String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.designation = designation;
		this.salary = salary;
		this.email = email;
	}

}
