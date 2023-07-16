package com.mindtree.restapp.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mindtree.restapp.converter.EmployeeConverter;
import com.mindtree.restapp.dto.EmployeeDto;
import com.mindtree.restapp.entity.Employee;
import com.mindtree.restapp.exception.daoexception.EmployeeNotFoundException;
import com.mindtree.restapp.service.EmployeeService;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EmployeeService employeeService;

	@Autowired
	private EmployeeConverter employeeConverter;

	@Test
	public void testGetAllEmployees() throws Exception {
		List<Employee> employees = Arrays.asList(new Employee(101, "Seshu", "Rao", "Java EE", 25000, "pari@gmail.com"),
				new Employee(102, "Seshu1", "Rao1", "Java EE1", 25000, "pari@gmail1.com")

		);

		when(employeeService.getAllEmployees()).thenReturn(employees);
		this.mockMvc.perform(get("/getAllEmployees")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.['message ']", hasSize(2))).andExpect(jsonPath("$['message '][0].id", is(101)))
				.andExpect(jsonPath("$['message '][1].id", is(102)));
		verify(employeeService, times(1)).getAllEmployees();
		verifyNoMoreInteractions(employeeService);

	}

	@Test
	public void testGetEmployeeById() throws Exception {
		Employee employee = new Employee(101, "Seshu", "Rao", "Java EE", 25000, "pari@gmail.com");
		when(employeeService.getEmployeeById(employee.getId())).thenReturn(employee);
		mockMvc.perform(get("/getEmployee/{id}", employee.getId())).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$['message '].id", is(101)))
				.andExpect(jsonPath("$['message '].firstName", is(employee.getFirstName())));

		verify(employeeService, times(1)).getEmployeeById(employee.getId());
		verifyNoMoreInteractions(employeeService);
	}

	@Test
	public void testGetEmployeeById_404_not_found() throws Exception {
		long mockId = 100;
		when(employeeService.getEmployeeById(mockId)).thenThrow(new EmployeeNotFoundException("Not Found"));
		mockMvc.perform(get("/getEmployee/{id}", mockId)).andExpect(status().isNotFound());
		verify(employeeService, times(1)).getEmployeeById(mockId);
		verifyNoMoreInteractions(employeeService);
	}

	@Test
	public void testAddEmployee() throws Exception {
		EmployeeDto employeeDto = new EmployeeDto("Seshu", "Rao", "Java EE", 25000, "pari@gmail.com");
		Employee employee = employeeConverter.dtoToEntity(employeeDto);

		doReturn(employee).when(employeeService).addNewEmployee(any());

		mockMvc.perform(post("/addEmployee").contentType(MediaType.APPLICATION_JSON).content(asJsonString(employeeDto)))
				.andExpect(status().isCreated());

		verify(employeeService, times(1)).addNewEmployee(any());
		verifyNoMoreInteractions(employeeService);
	}

	@Test
	public void testAddEmployee_400_bad_request() throws Exception {
		EmployeeDto employeeDto = new EmployeeDto("", "Rao", "Java EE", 25000, "pari@gmail.com");

		mockMvc.perform(post("/addEmployee").contentType(MediaType.APPLICATION_JSON).content(asJsonString(employeeDto)))
				.andExpect(status().isBadRequest());

		verify(employeeService, times(0)).addNewEmployee(employeeDto);
		verifyNoMoreInteractions(employeeService);
	}

	@Test
	public void testDeleteEmployee() throws Exception {
		Employee employee = new Employee(101, "Seshu", "Rao", "Java EE", 25000, "pari@gmail.com");

		when(employeeService.getEmployeeById(101)).thenReturn(employee);
		doNothing().when(employeeService).deleteEmployeeById(101);

		mockMvc.perform(delete("/deleteEmployee/{id}", 101)).andExpect(status().isNoContent());

		verify(employeeService, times(1)).deleteEmployeeById(101);

		verifyNoMoreInteractions(employeeService);
	}

	@Test
	public void testInternalServerError() throws Exception {
		long mockId = 100;
		mockMvc.perform(post("/getEmployee/{id}", mockId)).andExpect(status().isInternalServerError());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
