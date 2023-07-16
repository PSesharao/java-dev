package dynamicprogramming;
import java.util.Scanner;

/*Rod Cutting Problem
Given a rod of length n inches and an array of prices that contains prices 
of all pieces of size smaller than n. Determine the  maximum value obtainable 
by cutting up the rod and selling the pieces. 
Example: 
if length of the rod is 8 and the values of different pieces are given as 
following, then the maximum obtainable value is 22 (by cutting in two pieces 
of lengths 2 and 6)


length   | 1   2   3   4   5   6   7   8  
--------------------------------------------
price    | 1   5   8   9  10  17  17  20

*/
public class RodCuttingProblem {
	static int t[][] ;
	public static int rodCutting(int length[],int value[],int l,int n)
	{
		// initialization
		t = new int[n+1][l+1];
		for(int size=0;size<=n;size++)
			for(int len=0;len<=l;len++)
				if(size==0 || len==0)
						t[size][len] = 0;
		// Building remaining table
		for(int size=1;size<=n;size++)
			for(int len=1;len<=l;len++)
			{
				if(length[size-1]<=len)
					t[size][len] = Math.max((value[size-1]+t[size][len-length[size-1]]),(t[size-1][len]));
				else
					t[size][len]= t[size-1][len];
			}
		// final result
		return t[n][l];
	}
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int n,length[],l,value[];
		System.out.println("Enter no of items :");
		n=sc.nextInt();
		length = new int[n];
		value = new int[n];
		System.out.println("Enter the length of rod: ");
		l = sc.nextInt();
		System.out.println("Enter length's of "+n+" items :");
		for(int i=0;i<n;i++)
			length[i] = sc.nextInt();
		System.out.println("Enter values of "+n+" items :");
		for(int i=0;i<n;i++)
			value[i] = sc.nextInt();
		System.out.println(rodCutting(length, value, l, n));
		sc.close();
	}
}
