package assignment2;

import java.util.Scanner;

public class SubSetSumIterative49 {
	private static int[] findSubset(int size,int decimal)
	{
		int i;
		int binary[] = new int[size+1];
		binary[0] = 0;
		for(i=1;i<=size;i++)
			binary[i]=0;
		for(i=size;decimal!=0;i--)
		{
			binary[i] = decimal%2;
			decimal = decimal/2;
		}
		return binary;
	}
	public static void main(String[] args) {
		int arr[] ;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size :");
		int n= sc.nextInt();
		arr = new int [n+1];
		System.out.println("Enter the elements into array :");
		for(int i=1;i<=n;i++)
			arr[i] = sc.nextInt();
		System.out.println("Enter the sum :");
		int d = sc.nextInt();
		int noOfSubsets = (int) (Math.pow(2, n)-1);
		int subSets[][] = new int[0][];
		boolean flag = false;
		for(int i=1;i<=noOfSubsets;i++) {
			int binaryForm[] = findSubset(n, i);
			int sum =0;
			for(int j=1;j<=n;j++)
			{
				if(binaryForm[j]==1)
					sum+=arr[j];
			}
			if(sum == d)
			{
				flag = true;
				int set[] = new int [0];
				for(int j=1;j<=n;j++)
				{
					if(binaryForm[j]==1)
						set = addElement(set, arr[j]);
				}
			subSets = addSet(subSets, set);
			}
		}
		if(flag)
			printTuples(subSets);
		else
			System.out.println("No solution");
		sc.close();
	}
	private static int[] addElement(int[] set, int e) {
		int currLen=set.length;
		int temp[] = new int[currLen+1]; 
		for(int i=0;i<currLen;i++)
			temp[i]=set[i];
		temp[currLen] = e;
		return temp;
	}
	private static int[][] addSet(int[][] subSets, int[] set) {
		int currLen=subSets.length;
		int temp[][] = new int[currLen+1][]; 	
		for(int i=0;i<currLen;i++)
			temp[i]=subSets[i];
		temp[currLen] = set;
		return temp;
	}
	private static void printTuples(int [][] tuples) {
		for(int i=0;i<tuples.length;i++) {
			System.out.print("<");
			for(int j=0;j<tuples[i].length;j++)
				if(j==tuples[i].length-1)
					System.out.print(tuples[i][j]);
				else 
					System.out.print(tuples[i][j] + ",");
			System.out.print(">");
			System.out.println();
	   }		
	}
}
