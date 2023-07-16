package datastructures.lists;

import java.util.Iterator;
import java.util.LinkedList;

public class Iterators {

	public static void main(String[] args) {
		LinkedList<String> list= new LinkedList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		Iterator<String> it = list.iterator();
		while(it.hasNext())
		{
			String value = it.next();
			System.out.println(value);
		}
		System.out.println("Removing particular Item");
		it = list.iterator();
		while(it.hasNext())
		{
			String value = it.next();
			//System.out.println(value);
			if(value.equals("three")) {
				it.remove();
			}
		}
		it = list.iterator();
		while(it.hasNext())
		{
			String value = it.next();
			System.out.println(value);
		}
		
	}
}
