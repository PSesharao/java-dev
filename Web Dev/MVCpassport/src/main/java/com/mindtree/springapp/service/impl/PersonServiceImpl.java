package com.mindtree.springapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.springapp.entity.Person;
import com.mindtree.springapp.repository.PersonRepository;
import com.mindtree.springapp.service.PersonService;
@Service
public class PersonServiceImpl implements PersonService {
	@Autowired
	private PersonRepository personRepository;
	
	

	@Override
	public Person addPerson(Person person) {

		return personRepository.save(person);
	}

	@Override
	public Person getPersonById(long pid) {

		return personRepository.findById(pid).orElse(null);
				//.orElseThrow(() -> new ResourceNotFoundException("Person not found with id :" + pid));
	}

	@Override
	public Person updatePerson(Person person, long pid) {
		Person existingPerson = personRepository.findById(pid).orElse(null);
		existingPerson.setId(person.getId());
		existingPerson.setName(person.getName());
		existingPerson.setAge(person.getAge());
		existingPerson.setGender(person.getGender());
		existingPerson.setPassport(person.getPassport());
		return existingPerson;
	}

	@Override
	public Person deletePerson(long pid) {

		return null;
	}
	
	@Override
	public List<Person> getAllPersons() {
		// TODO Auto-generated method stub
		return personRepository.findAll();
	}

}
