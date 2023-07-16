package datastructures.sets;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import datastructures.lists.Employee;

public class HashedSet {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		HashedSet hst = new HashedSet();
		Set<Integer> hashSet = new HashSet<Integer>();
		Set<Employee> empSet = new HashSet<Employee>();
		hashSet.add(1);
		hashSet.add(2);
		hashSet.add(3);
		hashSet.add(4);
		hashSet.add(5);
		hashSet.add(6);
		System.out.println("Initial list :");
		hst.displayList(hashSet);
		System.out.println("Enter an integer to add into the set :");
		int userInput = input.nextInt();
		hashSet.add(userInput);
		System.out.println("After adding userInput:");
		hst.displayList(hashSet);
		hashSet.remove(5);
		System.out.println("After deleting element 5");
		hst.displayList(hashSet);
		System.out.println("After adding the element 6");
		hashSet.add(6);
		hst.displayList(hashSet);
		empSet.add(new Employee(1001, "Peter Berg"));
		empSet.add(new Employee(1002, "James Wann"));
		empSet.add(new Employee(1003, "Steven Smith"));
		empSet.add(new Employee(1004, "Issac Jack"));
		System.out.println("Initial employee list :");
		hst.displayEmployee(empSet);
		empSet.add(new Employee(1005, "Peter Swann"));
		System.out.println("After adding a new Employee :");
		hst.displayEmployee(empSet);
	}

	private void displayList(Set<Integer> hashSet) {
		Iterator<Integer> traverse = hashSet.iterator();
		while (traverse.hasNext())
			System.out.println(traverse.next());
	}

	private void displayEmployee(Set<Employee> empSet) {
		Iterator<Employee> traverse = empSet.iterator();
		while (traverse.hasNext())
			traverse.next().displayEmployee();
	}
}
