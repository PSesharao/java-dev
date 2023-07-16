package datastructures.sets;

import java.util.Set;
import java.util.TreeSet;

class Person implements Comparable<Person> {
	private String name;
	private int id;
	private int salary;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Person(String name, int id, int salary) {
		super();
		this.name = name;
		this.id = id;
		this.salary = salary;
	}

	@Override
	public int compareTo(Person person) {
		int id1 = this.getId();
		int id2 = person.getId();
		return id2 - id1;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", id=" + id + ", salary=" + salary + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + salary;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (salary != other.salary)
			return false;
		return true;
	}

}

public class TreeSetExample {
	public static void main(String[] args) {
		Set<Person> personTreeSet = new TreeSet<>();
		personTreeSet.add(new Person("sesharao", 105, 1000));
		personTreeSet.add(new Person("ajith", 106, 1070));
		personTreeSet.add(new Person("mohan", 104, 1000));
		System.out.println(personTreeSet);
	}
}
