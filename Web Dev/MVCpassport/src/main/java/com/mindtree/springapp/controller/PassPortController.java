package com.mindtree.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.springapp.Dto.PassportDto;
import com.mindtree.springapp.converter.PassportConverter;
import com.mindtree.springapp.entity.Passport;
import com.mindtree.springapp.entity.Person;
import com.mindtree.springapp.exception.DuplicatePassportException;
import com.mindtree.springapp.exception.PersonIssueException;
import com.mindtree.springapp.service.PassportService;
import com.mindtree.springapp.service.PersonService;

@Controller
public class PassPortController {

	@Autowired
	private PassportService passportService;

	@Autowired
	private PersonService personService;
	
	@Autowired
	private PassportConverter passportConverter;

	@RequestMapping("/passport")
	public ModelAndView passport() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("passport");
		List<Person> plist = personService.getAllPersons();
		mv.addObject("personList", plist);
		return mv;
	}
	
	@RequestMapping("/addpassport")
	public String addPassport(PassportDto passportDto, @RequestParam("personId") long personId) throws PersonIssueException, DuplicatePassportException {
		Passport passport = passportConverter.dtoToEntity(passportDto);
		Person person = personService.getPersonById(personId);
		Passport prevHistory = passportService.getPassportById(passport.getPassNum());
		if (prevHistory != null)
			throw new DuplicatePassportException(
					"Passport " + passport.getPassNum() + " already assigned to " + prevHistory.getPerson().getName() +" give another passport");

		if (person.getPassport() != null)
			throw new PersonIssueException(
					person.getName() + " has already been assigned with passport " + person.getPassport().getPassNum() +" choose another person");
		person.setPassport(passport);
		personService.addPerson(person);
		passport.setPerson(person);
		passportService.addpassport(passport);
		return "success";
	}
}
