package assignment2;

import java.util.Scanner;

public class Unique36 {
	/*public int [] uniqueElements(int a1[],int a2[])
	{
		Integer arr1[] = new Integer[a1.length];
		for(int i=0;i<a1.length;i++)
			arr1[i]=Integer.valueOf(a1[i]);
		Integer arr2[] = new Integer[a2.length];
		for(int i=0;i<a2.length;i++)
			arr2[i]=Integer.valueOf(a2[i]);
		List<Integer> list1 = Arrays.asList(arr1);
		List<Integer> list2 = Arrays.asList(arr2);
		Set<Integer> union = new TreeSet<Integer>(list1);
		union.addAll(list2);
		Set<Integer> intersection = new TreeSet<Integer>(list1);
		intersection.retainAll(list2);
		union.removeAll(intersection);
		int unique [] = new int[union.size()];
		int j=0;
		for(Integer e : union)
			unique[j++] = e;
		return unique;
	}
	public static void main(String[] args) {
		Unique36 u = new Unique36();
		int a1[] = {10, 5, 20, 15, 25, 30};
		int a2[] = {50, 12, 5, 30, 15, 70};
		System.out.println(Arrays.toString(u.uniqueElements(a1,a2)));
	}*/
	public static void main(String[] args) {
		int l1,l2;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length of first array :");
		l1 = sc.nextInt();
		System.out.println("Enter "+(l1)+" elements into array1:");
		int a1[] = new int[l1];
		for(int i=0;i<l1;i++)
			a1[i]=sc.nextInt();
		System.out.println("Enter length of second array :");
		l2= sc.nextInt();
		int a2[] = new int[l2];
		System.out.println("Enter "+(l2)+" elements into array2:");
		for(int i=0;i<l2;i++)
			a2[i]=sc.nextInt();	
		int uniqueArray [] = uniqueElements(a1,a2);
		System.out.print("The unique elements are :");
		for(int i=0;i<uniqueArray.length;i++)
			if(i!=uniqueArray.length-1)
				System.out.print(uniqueArray[i]+",");
			else 
				System.out.print(uniqueArray[i]);
		
		sc.close();
	}
	private static int[] uniqueElements(int[] a1, int[] a2) {
		int uniqueArray [] = new int [0];
		int mergedArray[] = mergeArrays(a1, a2);
		int len = mergedArray.length;
		int freqArray [] = new int[len];
		for(int i=0;i<len;i++)
			freqArray[i] = -1;
		for(int i=0;i<len;i++) {
			int count = 1;
			for(int j=i+1;j<len;j++)
				if(mergedArray[i] == mergedArray[j])
				{
					count++;
					freqArray[j]=0;
				}
			if(freqArray[i]!=0)
				freqArray[i] = count;
		}
		for(int i=0;i<len;i++)
			if(freqArray[i] == 1)
				uniqueArray = addElement(uniqueArray,mergedArray[i]);
		return uniqueArray;
	}
	
	private static int[] addElement(int[] uniqueArray, int e) {
		int currLen = uniqueArray.length;
		int temp [] = new int [currLen+1];
		for(int i=0;i<currLen;i++)
			temp[i]=uniqueArray[i];
		temp[currLen] = e;
		return temp;
	}
	private static int[] mergeArrays(int a1[],int a2[]) {
		int l1=a1.length,l2 = a2.length;
		int mergedArray[] = new int[l1+l2];
		for(int i=0;i<l1;i++)
			mergedArray[i] = a1[i];
		for(int i=l1;i<l1+l2;i++)
			mergedArray[i] = a2[i-l1];
		return mergedArray;
	}
	
}
