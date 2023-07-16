package dynamicprogramming;

import java.util.Scanner;

/*Coin Change Problem Maximum Number of ways
Given a value N, if we want to make change for N cents, and we have 
infinite supply of each of S = { S1, S2, .. , Sm} valued coins, how many 
ways can we make the change? The order of coins doesn’t matter.
Example:
for N = 4 and S = {1,2,3}, there are four solutions: 
{1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4.*/
public class CoinChangeMaxWays {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n,coins[],sum;
		System.out.println("Enter no coins :");
		n = sc.nextInt();
		coins = new int[n];
		System.out.println("Enter "+n+" coins :");
		for(int i=0;i<n;i++)
			coins[i] = sc.nextInt();
		System.out.println("Enter the sum to make :");
		sum = sc.nextInt();
		sc.close();
		int noOfWays = maxiumNoofWays(coins, n, sum);
		System.out.println("The total no of ways is :" + noOfWays);
	}
	private static int maxiumNoofWays(int coins[] , int n ,int sum) {
		int t[][] = new int[n+1][sum+1];
		// Initialization
		for(int size=0;size<=n;size++)
			for(int total =0;total<=sum;total++)
			{
				if(size == 0)
					t[size][total] = 0;
				if(total == 0)
					t[size][total] = 1;
			}
		// remaining table
		for(int size=1;size<=n;size++)
			for(int total =1;total<=sum;total++)
			{
				if(coins[size-1]<=total)
					t[size][total] = (t[size/*Unbounded no -1*/][total-coins[size-1]] + t[size-1][total]);
				else
					t[size][total] =  t[size-1][total];
			}
		
		// final result
		return t[n][sum];
	}
}
