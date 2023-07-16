package datastructures.lists;
import java.util.*;
public class LinkedL {
	public static void main(String[] args) {
		List<Integer> A = new ArrayList<Integer>();
		List<Integer> LL = new LinkedList<Integer>();
		doTimings("ArrayList", A);
		doTimings("LinkedList", LL);
	}
	private static void doTimings( String type, List<Integer> L) {
		for (int i = 0; i < 1E5; i++) {
			L.add(i);
		}
		System.out.println("Adding items at the end of the list");
		long start = System.currentTimeMillis();
		
		for (int i = 0; i < 1E5; i++) {
			L.add(i);
		}
		
		long end = System.currentTimeMillis();
		System.out.println("Time taken is :"+(end-start)+ " ms for " +type);
		
		System.out.println("Adding items at the beginning of the list");
		
		start = System.currentTimeMillis();
		for (int i = 0; i < 1E5; i++) {
			L.add(0,i);
		}
		end = System.currentTimeMillis();
		System.out.println("Time taken is :"+(end-start)+ " ms for " +type);
	}
}
