package dynamicprogramming;
/* 
 Count of subsets sum with a Given sum
Given an array arr[] of length N and an integer X, 
the task is to find the number of subsets with sum equal to X.
Example:

Input: arr[] = {1, 2, 3, 3}, X = 6
Output: 3
All the possible subsets are {1, 2, 3},
{1, 2, 3} and {3, 3}
*/
public class NoOfSubsetsWithSum {
	static int t[][] = new int[102][1002];
	public static int noOfSubsetsWithSum(int array[],int sum,int n)
	{
		// initialization
		for(int size=0;size<=n;size++)
			for(int total =0;total<=sum;total++)
			{
				if(size == 0)
					t[size][total] = 0;
				if(total == 0)
					t[size][total] = 1;
			}
		// Building remaining table
		
		for(int size=1;size<=n;size++)
			for(int total =1;total<=sum;total++)
			{
				if(array[size-1]<=total)
					t[size][total] = t[size-1][total-array[size-1]] + t[size-1][total];
				else
					t[size][total] =  t[size-1][total];
			}
		
		// final result
		return t[n][sum];
	}
}
