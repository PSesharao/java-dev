package datastructures.sets;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
public class Sets {
	public static void main(String[] args) {
		Set<String> hset = new HashSet<String>();
		Set<String> lhset = new LinkedHashSet<String>();
		Set<String> tset = new TreeSet<String>();
		testSet("Hashset",hset);
		testSet("LinkedHashset",lhset);
		testSet("Treeset",tset);
	}
	public static void testSet(String type,Set<String> set) {
		if (set.isEmpty()) {
			System.out.println("It's empty set");
		}
		set.add("zip");
		set.add("ankle");
		set.add("jaro");
		set.add("apple");
		// duplicate adding
		set.add("ankle");
		if (set.contains("zip")) {
			System.out.println("It contains zip");
		}
		Set<String> intersection = new HashSet<String>(set);
		Set<String> set2 = new HashSet<String>();
		set2.add("zip");
		set2.add("ankle");
		set2.add("oil");
		intersection.retainAll(set2);
		System.out.println("The intersion of the both sets is "+ intersection);
		Set<String> difference = new HashSet<String>(set);
		Set<String> union = new HashSet<String>(set);
		union.addAll(set2);
		System.out.println("The union is :" + union );
		difference.removeAll(set2);
		System.out.println("The difference is :" + difference);
		System.out.println(set + " By using type "+type);
		// Iteration
		System.out.println("Iterating using "+type);
		for(String s : set)
		{
			System.out.print(s +" ");
		}
		System.out.println();
	}
}
