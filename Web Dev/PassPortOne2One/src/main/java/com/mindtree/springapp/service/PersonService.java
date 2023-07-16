package com.mindtree.springapp.service;

import java.util.List;

import com.mindtree.springapp.entity.Person;

public interface PersonService {
	 Person addPerson(Person person);
	 
	 Person getPersonById(String pid);
	 
	 Person updatePerson(Person person , String pid);
	 
	 Person deletePerson(String pid);
	 
	 List<Person> getAllPersons();
}
