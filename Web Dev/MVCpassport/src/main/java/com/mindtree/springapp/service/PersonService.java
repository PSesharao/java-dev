package com.mindtree.springapp.service;

import java.util.List;

import com.mindtree.springapp.entity.Person;

public interface PersonService {
	 Person addPerson(Person person);
	 
	 Person getPersonById(long pid);
	 
	 Person updatePerson(Person person , long pid);
	 
	 Person deletePerson(long pid);
	 
	 List<Person> getAllPersons();
}
