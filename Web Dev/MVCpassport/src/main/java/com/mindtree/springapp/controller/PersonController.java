package com.mindtree.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.mindtree.springapp.Dto.PersonDto;
import com.mindtree.springapp.converter.PersonConverter;
import com.mindtree.springapp.entity.Person;
import com.mindtree.springapp.service.PersonService;

@Controller
public class PersonController {
	@Autowired
	private PersonConverter personConverter;

	@Autowired
	private PersonService personService;

	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	

	@RequestMapping("/person")
	public String person() {
		return "person";
	}
	
	@RequestMapping("/addperson")
	public ModelAndView addperson(PersonDto personDto) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addperson");
		Person person = personConverter.dtoToEntity(personDto);
		personService.addPerson(person);
		return mv;
	}
    
	

}
