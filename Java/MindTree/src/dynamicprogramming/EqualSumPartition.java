package dynamicprogramming;
/*Equal Sum Partition Problem
Partition problem is to determine whether a given set 
can be partitioned into two subsets such that the sum of 
elements in both subsets is same.
Examples:

arr[] = {1, 5, 11, 5}
Output: true 
The array can be partitioned as {1, 5, 5} and {11}*/
public class EqualSumPartition {
	static int array[];
	static int n;
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
		
		for(int size=0;size<=n;size++)
			for(int total =0;total<=sum;total++)
			{
				if(array[size-1]<=total)
					t[size][total] = t[size-1][total-array[size-1]] || t[size-1][total];
				else
					t[size][total] =  t[size-1][total];
			}
		
		// final result
		return t[n][sum];
	}
	public static boolean equalSumPartion(int sumOfArray)
	{
		if(sumOfArray%2!=0)
		return false;
		else
		return subsetSum(array, sumOfArray/2, n);
	}
}
