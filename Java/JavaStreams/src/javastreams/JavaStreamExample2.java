package javastreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class SortDescending implements Comparator<String>
{

	@Override
	public int compare(String o1, String o2) {
		return -o1.compareToIgnoreCase(o2);
	}
	
}
public class JavaStreamExample2 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Heena");
		list.add("Arun");
		list.add("Sumanth");
		list.add("Mohan");
		list.add("Rajesh");
		
		// getting the names which end with 'h' in capital letters
		
		list.
		stream().
		filter(filEl -> filEl.endsWith("h")).
		map(mapEl -> mapEl.toUpperCase()).
		forEach(ele -> System.out.println(ele));
		
		//average of squares of an int array
		Arrays.stream(new int[] {2, 4, 6, 8, 10})
			.map(x -> x * x)
			.average()
			.ifPresent(System.out::println);
		
		//sorting list of names in descending order and printing the results in Caps
		
		list.
		stream().
		sorted(new SortDescending()).
		map(mapEl -> mapEl.toUpperCase()).
		forEach(ele -> System.out.println(ele));
	}
}
