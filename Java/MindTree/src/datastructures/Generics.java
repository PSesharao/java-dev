package datastructures;

import java.util.LinkedList;
import java.util.List;

public class Generics {
	public static void main(String[] args) {
		// Generic list
		List<Object> list = new LinkedList<>();
		list.add(1);
		list.add("string");
		list.add(true);
		System.out.println(list);
	}
}
