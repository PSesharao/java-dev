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
public class Knapsack01Bottomup {
	static int t[][] = new int[102][1002];
	public static int knapsackBottomUp(int weight[],int value[],int w,int n)
	{
		// initialization
		for(int size=0;size<=n;size++)
			for(int wt=0;wt<=w;wt++)
				if(size==0 || wt==0)
						t[size][wt] = 0;
		// Building remaining table
		for(int size=0;size<=n;size++)
			for(int wt=0;wt<=w;wt++)
			{
				if(weight[size-1]<=wt)
					t[size][wt] = Math.max((value[size-1]+t[size-1][wt-weight[size-1]]),(t[size-1][wt]));
				else
					t[size][wt]= t[size-1][wt];
			}
		// final result
		return t[n][w];
	}
}