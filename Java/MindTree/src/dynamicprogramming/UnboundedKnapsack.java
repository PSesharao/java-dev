package dynamicprogramming;

import java.util.Scanner;

/*Unbounded Knapsack (Repetition of items allowed)
Given a knapsack weight W and a set of n items with certain value vali and weight wti, we need to calculate minimum amount that could make up this quantity exactly. This is different from classical Knapsack problem, here we are allowed to use unlimited number  of instances of an item.
Examples:

Input : W = 100
      val[]  = {1, 30}
      wt[] = {1, 50}
Output : 100
There are many ways to fill knapsack.
1) 2 instances of 50 unit weight item.
2) 100 instances of 1 unit weight item.
3) 1 instance of 50 unit weight item and 50
  instances of 1 unit weight items.
We get maximum value with option 2.
Input : W = 8
       val[] = {10, 40, 50, 70}
       wt[]  = {1, 3, 4, 5}       
Output : 110 
We get maximum value with one unit of
weight 5 and one unit of weight 3.
*/
public class UnboundedKnapsack {
	static int t[][] ;
	public static int unboundedKnapsack(int weight[],int value[],int w,int n)
	{
		// initialization
		t = new int[n+1][w+1];
		for(int size=0;size<=n;size++)
			for(int wt=0;wt<=w;wt++)
				if(size==0 || wt==0)
						t[size][wt] = 0;
		// Building remaining table
		for(int size=1;size<=n;size++)
			for(int wt=1;wt<=w;wt++)
			{
				if(weight[size-1]<=wt)
					t[size][wt] = Math.max((value[size-1]+t[size][wt-weight[size-1]]),(t[size-1][wt]));
				else
					t[size][wt]= t[size-1][wt];
			}
		// final result
		return t[n][w];
	}
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int n,weight[],w,value[];
		System.out.println("Enter no of items :");
		n=sc.nextInt();
		weight = new int[n];
		value = new int[n];
		System.out.println("Enter the weight of knapsack ");
		w = sc.nextInt();
		System.out.println("Enter weights of "+n+" items :");
		for(int i=0;i<n;i++)
			weight[i] = sc.nextInt();
		System.out.println("Enter values of "+n+" items :");
		for(int i=0;i<n;i++)
			value[i] = sc.nextInt();
		System.out.println(unboundedKnapsack(weight, value, w, n));
		sc.close();
	}
}
