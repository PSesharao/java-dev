package datastructures;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Person
{
	private int id;
	private String name;
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		return true;
	}
	
}
public class CustomObjects {
	public static void main(String[] args) {
		Map<Person,Integer> map = new HashMap<Person,Integer>();
		Set<Person> set = new HashSet<Person>();
		Person p1 = new Person(101, "Sesharao");
		Person p2 = new Person(102, "Srinu");
		Person p3 = new Person(103, "Naveen");
		Person p4 = new Person(101, "Sesharao");
		map.put(p1,1);
		map.put(p2,2);
		map.put(p3,3);
		map.put(p4,1);
		System.out.println("The contents on the map");
		for(Person key : map.keySet())
		{
			System.out.println(key + " : " + map.get(key));
		}
		System.out.println("The contents on the set");
		set.add(p1);
		set.add(p2);
		set.add(p3);
		set.add(p4);
		for(Person p : set)
		{
			System.out.println(p);
		}
	}
}
