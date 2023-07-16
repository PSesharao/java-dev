package javastreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreamExample1 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Heena");
		list.add("Arun");
		list.add("Sumanth");
		list.add("Mohan");
		list.add("Rajesh");
		
		System.out.println("Getting all names with length 5 ");
		
		list.
		stream().  // converting into stream
		filter(listEl -> listEl.length()==5). // intermediate operation
		forEach(filterEl->System.out.println(filterEl));  // terminalOperation
		
		System.out.println("Getting all names which ends with 'h' ");
		
		list.
		stream().
		filter(listEl -> listEl.endsWith("h")).
		forEach(System.out::println);
		
		System.out.println("Getting all names which ends with 'h' limiting to 1");
		
		list.
		stream().
		filter(listEl -> listEl.endsWith("h")).
		limit(1).
		forEach(System.out::println);
		
		System.out.println("Printing first 10 numbers :");
		
		IntStream
		.range(1, 10)
		.forEach(num->System.out.print(num+" "));
		
		System.out.println("\nSkipping first 5");
		IntStream
		.range(1, 10)
		.skip(5)
		.forEach(x -> System.out.print(x+" "));
		
		System.out.println();
		
		Stream.of("Ava", "Aneri", "Alberto")
		.sorted()
		.forEach(System.out::println);
		
		String[] names = {"Al", "Ankit", "Kushal", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah"};
		Arrays.stream(names)	// same as Stream.of(names)
			.filter(x -> x.startsWith("S"))
			.sorted()
			.forEach(System.out::println);
		
	}
}
