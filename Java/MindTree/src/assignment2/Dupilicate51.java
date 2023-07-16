package assignment2;
//import java.util.HashSet;
import java.util.Scanner;
//import java.util.Set;
public class Dupilicate51 {
	public static void main(String[] args) {
		int l;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length of array :");
		l = sc.nextInt();
		System.out.println("Enter "+(l)+" elements into array:");
		int a[] = new int[l];
		for(int i=0;i<l;i++)
			a[i]=sc.nextInt();
		int duplicateArray []= duplicateElements(a);
		if(duplicateArray.length==0)
			System.out.println(-1);
		else 
		for(int i=0;i<duplicateArray.length;i++)
			if(i!=duplicateArray.length-1)
				System.out.print(duplicateArray[i]+",");
			else 
				System.out.print(duplicateArray[i]);
		sc.close();
	}
	private static int[] duplicateElements(int[] a) {
		int duplicateArray [] = new int [0];
		int len = a.length;
		int freqArray [] = new int[len];
		for(int i=0;i<len;i++)
			freqArray[i] = -1;
		for(int i=0;i<len;i++) {
			int count = 1;
			for(int j=i+1;j<len;j++)
				if(a[i] == a[j])
				{
					count++;
					freqArray[j]=0;
				}
			if(freqArray[i]!=0)
				freqArray[i] = count;
		}
		for(int i=0;i<len;i++)
			if(freqArray[i]>1)
				duplicateArray = addElement(duplicateArray,a[i]);
		return duplicateArray;
	}
	
	private static int[] addElement(int[] duplicateArray, int e) {
		int currLen = duplicateArray.length;
		int temp [] = new int [currLen+1];
		for(int i=0;i<currLen;i++)
			temp[i]=duplicateArray[i];
		temp[currLen] = e;
		return temp;
	}
}
	/*public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array :");
		int size = sc.nextInt();
		Integer[] array = new Integer[size]; 
		System.out.println("Enter the array :");
        for(int i=0;i<size;i++)
        {
        	int n =sc.nextInt();
        	array[i] = Integer.valueOf(n);
        }
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> duplicates = new HashSet<Integer>();
           
        for(int i = 0; i < size ; i++)
        {
            if(set.add(array[i]) == false)
            {
                duplicates.add(array[i]);
            }
        }
          
        if(duplicates.size() == 0)
        {
            duplicates.add(-1);
        }
         
        System.out.println(duplicates);
        sc.close(); 
	}*/

