package com.mindtree.springapp.controller;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mindtree.springapp.Dto.PersonDto;
import com.mindtree.springapp.converter.PersonConverter;
import com.mindtree.springapp.entity.Passport;
import com.mindtree.springapp.entity.Person;
import com.mindtree.springapp.exception.ResourceNotFoundException;
import com.mindtree.springapp.service.PassportService;
import com.mindtree.springapp.service.PersonService;

@RestController
@RequestMapping("api/person")
public class PersonController {
	@Autowired
	private PersonConverter personConverter;
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private PassportService passportService ;
	
	@PostMapping("/add")
	public ResponseEntity<Map<String , Object>> addPerson(@RequestBody PersonDto personDto)
	{
		Person person = personConverter.dtoToEntity(personDto);
		personService.addPerson(person);
		Passport passport = person.getPassport();
		passport.setPerson(person);
		passportService.addpassport(passport);
		Map<String , Object> response = new LinkedHashMap<>();
		response.put("Header", "PassportProject");
		response.put("Error", false);
		response.put("message :", personConverter.entityToDto(person));
		response.put("HttpRequest ", HttpStatus.ACCEPTED);
		return new ResponseEntity<Map<String, Object>>(response , HttpStatus.OK );
		
	}
	

	@GetMapping("/get/{id}")
	public ResponseEntity<Map<String , Object>> getPersonById(@PathVariable(value = "id") String pid)
	{
		Map<String , Object> response = new LinkedHashMap<>();
		response.put("Header", "PassportProject");
		
		Person person = personService.getPersonById(pid);
		if(person == null)
		{
			response.put("message :", new ResourceNotFoundException("User not found with id :" + pid));
			response.put("Error", true);
		}
		else
		{
			response.put("Error", false);
			response.put("message :", person);
			response.put("HttpRequest ", HttpStatus.ACCEPTED);
		}
		
		return new ResponseEntity<Map<String, Object>>(response , HttpStatus.OK );
	}
	
	
	
}
