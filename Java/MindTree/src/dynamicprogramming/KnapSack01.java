package dynamicprogramming;
/*0-1 Knapsack Problem solution using recursion(Overlapping Subproblems).
Example:
 Given weights and values of n items, put these items in a knapsack of 
 capacity W to get the maximum total value in the knapsack. In other words, 
 given two integer arrays val[0..n-1] and wt[0..n-1] which represent values 
 and weights associated with n items respectively. Also given an integer W 
 which represents knapsack capacity, find out the maximum value subset of 
 val[] such that sum of the weights of this subset is smaller than or equal to W.
  You cannot break an item, either pick the complete item, 
  or don’t pick it (0-1 property).
  */
public class KnapSack01 {
	public static int recursiveKnapsack01(int weight[],int value[],int w,int n)
	{
		if(n==0 || w==0)
			return 0;
		if(weight[n-1]<=w)
			return Math.max((value[n-1]+recursiveKnapsack01(weight, value, w-weight[n-1], n-1)), recursiveKnapsack01(weight, value, w, n-1));
		//if(weight[n-1]>w)
		else
			return recursiveKnapsack01(weight, value, w, n-1);
	}
}
