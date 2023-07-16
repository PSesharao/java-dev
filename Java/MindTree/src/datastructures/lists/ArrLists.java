package datastructures.lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
public class ArrLists {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		ArrLists lst = new ArrLists();
		List<Integer> arrayList = new ArrayList<Integer>();
		List<Employee> empList = new ArrayList<Employee>();
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(4);
		arrayList.add(5);
		arrayList.add(6);
		System.out.println("Initial list :");
		lst.displayList(arrayList);
		System.out.println("Enter an integer to add into the list :");
		int userInput = input.nextInt();
		arrayList.add(userInput);
		System.out.println("After adding userInput:");
		lst.displayList(arrayList);
		arrayList.set(3, 5);
		System.out.println("After updating 4 th element to 5 :");
		lst.displayList(arrayList);
		arrayList.remove(5);
		System.out.println("After deleting 6 th element ");
		lst.displayList(arrayList);
		arrayList.add(0, 6);
		System.out.println("After adding 6 at the 0 index ");
		lst.displayList(arrayList);
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
		lst.useIterator(arrayList);
	}

	private void displayList(List<Integer> arrayList) {
		for (int i = 0; i < arrayList.size(); i++)
			System.out.println(arrayList.get(i));
	}

	private void displayEmployee(List<Employee> empList) {
		for (int i = 0; i < empList.size(); i++)
			empList.get(i).displayEmployee(); 
	}

	private void useIterator(List<Integer> arrayList) {

		Iterator<Integer> traverse = arrayList.iterator();
		System.out.println("Displaying foreward list :");
		while (traverse.hasNext()) {
			System.out.println(traverse.next());
		}
		traverse = arrayList.iterator();
		System.out.println("Removing 3 in list");
		while (traverse.hasNext()) {
			if (traverse.next() == 3)
				traverse.remove();
		}
		traverse = arrayList.iterator();
		System.out.println("Displaying foreward list :");
		while (traverse.hasNext()) {
			System.out.println(traverse.next());
		}
	}
}
