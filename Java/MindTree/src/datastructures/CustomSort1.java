package datastructures;

import java.util.ArrayList;
import java.util.Collections;

class Person1 implements Comparable<Person1>
{
	private String name;
	
	public Person1(String name) {
		super();
		this.name = name;
	}

	@Override
	public int compareTo(Person1 people) {
		int l1=this.name.length();
		int l2=people.name.length();
		if(l1 > l2)
		{
			return 1;
		}
		else if(l1 < l2)
		{
			return -1;
		}
		return this.name.compareTo(people.name);
	}

	@Override
	public String toString() {
		return  name  ;
	}
	
}
public class CustomSort1 {
	public static void main(String[] args) {
	ArrayList<Person1> ppl = new ArrayList<Person1>();
	ppl .add(new Person1("joe"));
	ppl.add(new Person1("A"));
	ppl.add(new Person1("philip"));
	ppl.add(new Person1("B"));
	ppl.add(new Person1("jak"));
	ppl.add(new Person1("Andrew"));
	ppl.add(new Person1("Anderson"));
	System.out.println("Before Sorting");
	System.out.println(ppl);
	System.out.println("After Sorting");
	Collections.sort(ppl);
	System.out.println(ppl);
	}
}
