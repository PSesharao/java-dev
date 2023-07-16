package datastructures.lists;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LinkLists {
	private static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		LinkLists lst = new LinkLists();
		List<Integer> linkedList = new LinkedList<Integer>();
		List<Employee> empList = new LinkedList<Employee>();
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		linkedList.add(4);
		linkedList.add(5);
		linkedList.add(6);
		System.out.println("Initial list :");
		lst.displayList(linkedList);
		System.out.println("Enter an integer to add into the list :");
		int userInput = input.nextInt();
		linkedList.add(userInput);
		System.out.println("After adding userInput:");
		lst.displayList(linkedList);
		linkedList.set(3, 5);
		System.out.println("After updating 4 th element to 5 :");
		lst.displayList(linkedList);
		linkedList.remove(5);
		System.out.println("After deleting 6 th element ");
		lst.displayList(linkedList);
		linkedList.add(0, 6);
		System.out.println("After adding 6 at the 0 index ");
		lst.displayList(linkedList);
		empList.add(new Employee(1001, "Peter Berg"));
		empList.add(new Employee(1002, "James Wann"));
		empList.add(new Employee(1003, "Steven Smith"));
		empList.add(new Employee(1004, "Issac Jack"));
		System.out.println("Initial employee list :");
		lst.displayEmployee(empList);
		empList.add(new Employee(1005, "Peter Swann"));
		System.out.println("After adding a new Employee :");
		lst.displayEmployee(empList);
		empList.get(3).setName("Lex Luther");
		System.out.println("After updating 4th Emplyee’s name to “Lex Luthor”:");
		lst.displayEmployee(empList);
		empList.remove(1);
		System.out.println("After deleting 2nd Employee :");
		lst.displayEmployee(empList);
		System.out.println("Inserting a new employee to 0th index ");
		empList.add(0, new Employee(1000, "Shane Bond"));
		lst.displayEmployee(empList);
	}
	private void displayList(List<Integer> linkedList) {
		for (int i = 0; i < linkedList.size(); i++)
			System.out.println(linkedList.get(i));
	}

	private void displayEmployee(List<Employee> empList) {
		for (int i = 0; i < empList.size(); i++)
			empList.get(i).displayEmployee();
	}
}
