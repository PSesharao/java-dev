 package dynamicprogramming;
/* Subset Sum Problem(Dynamic Programming)
Given a set of non-negative integers, and a value sum, 
determine if there is a subset of the given set with sum equal to given sum.
Example:

Input:  set[] = {3, 34, 4, 12, 5, 2}, sum = 9
Output:  True  //There is a subset (4, 5) with sum 9.*/
public class SubsetSum {
	static boolean t[][] = new boolean[102][1002];
	public static boolean subsetSum(int array[],int sum,int n)
	{
		// initialization
		for(int size=0;size<=n;size++)
			for(int total =0;total<=sum;total++)
			{
				if(size == 0)
					t[size][total] = false;
				if(total == 0)
					t[size][total] = true;
			}
		// Building remaining table
		
		for(int size=1;size<=n;size++)
			for(int total =1;total<=sum;total++)
			{
				if(array[size-1]<=total)
					t[size][total] = t[size-1][total-array[size-1]] || t[size-1][total];
				else
					t[size][total] =  t[size-1][total];
			}
		
		// final result
		return t[n][sum];
	}
}
