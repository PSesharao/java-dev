package datastructures.lists;
import java.util.*;//ArrayList;
public class ArrayL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A = new ArrayList<Integer>();
		// Adding elements
		A.add(10);
		A.add(20);
		A.add(30);
		// Indexing
		System.out.println(A.get(0));
		// not work System.out.println(A[0]);
		// Iterating
		System.out.println("Iteration I");
		for (int i = 0; i < A.size(); i++) {
			System.out.println(A.get(i));
		}
		System.out.println("Iteration II");
		for(Integer a : A)
		{
			System.out.println(a);
		}
		System.out.println("Removing elements ");
		//from back is easy
		// from front it take more time bcz to move all elements 1 step back
		
		A.remove(A.size()-1);
		
		for(Integer a : A)
		{
			System.out.println(a);
		}
		
		// List interface ...
		List<Integer> L = new ArrayList<Integer>();
	}

}
