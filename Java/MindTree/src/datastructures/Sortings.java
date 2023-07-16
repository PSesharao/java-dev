package datastructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class StringLengthComparator implements Comparator<String>
{
	@Override
	public int compare(String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();
		if (len1 > len2) {
			return 1;
		} else if (len1 < len2) {
			return -1;
		}
		return 0;
	}
	
}
class ReverseAlphabeticalComparator implements Comparator<String>
{

	@Override
	public int compare(String s1, String s2) {
		return -s1.compareTo(s2);
	}
	
}
public class Sortings {
	public static void main(String[] args) {
		List<String> l = new ArrayList<String>();
		l.add("one");
		l.add("ball");
		l.add("cat");
		l.add("apple");
		System.out.println("Before sorting :"+l);
		Collections.sort(l,new StringLengthComparator());
		System.out.println("After sorting :"+l);
		System.out.println("Before sorting :"+l);
		Collections.sort(l,new ReverseAlphabeticalComparator());
		System.out.println("After sorting :"+l);
		List<Integer> li = new ArrayList<Integer>();
		li.add(12);
		li.add(13);
		li.add(2);
		li.add(87);
		li.add(9);
		System.out.println("For integers :");
		System.out.println("Before sorting :");
		System.out.println(li);
		System.out.println("After sorting :");
		Collections.sort(li);
		System.out.println(li);
		System.out.println("Sorting in descending order");
		// Anonymous class 
		Collections.sort(li,new Comparator<Integer>() {

			@Override
			public int compare(Integer n1, Integer n2){
				return -n1.compareTo(n2);
			}
			
		});
		System.out.println(li);
	}
}
