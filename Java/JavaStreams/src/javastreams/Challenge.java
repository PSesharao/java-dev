package javastreams;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Person
{
	private String name;
	private int salary ;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Person(String name, int salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", salary=" + salary + "]";
	}
}

public class Challenge {
	public static void main(String[] args) {
		List<Person> personList = new LinkedList<>();
		personList.add(new Person("Sesharao", 10000));
		personList.add(new Person("Mohith", 15000));
		personList.add(new Person("Rajesh", 18000));
		personList.add(new Person("Balu", 19000));
		personList = personList.stream().map(person ->{
			person.setSalary(person.getSalary()+5000);
			return person;
		}).collect(Collectors.toList());
		//System.out.println(personList);
		personList.forEach(System.out::println);
		personList.sort((Person p1 ,  Person p2)->p2.getSalary()-p1.getSalary());
		System.out.println();
		personList.forEach(System.out::println);
	}
	
}
