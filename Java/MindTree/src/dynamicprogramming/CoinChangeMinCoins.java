package dynamicprogramming;

import java.util.Scanner;

/*Given a value V, if we want to make change for V cents, 
and we have infinite supply of each of C = { C1, C2, .. , Cm} valued coins, 
what is the minimum number of coins to make the change?
Examples:

Input: coins[] = {25, 10, 5}, V = 30
Output: Minimum 2 coins required
We can use one coin of 25 cents and one of 5 cents 

Input: coins[] = {9, 6, 5, 1}, V = 11
Output: Minimum 2 coins required
We can use one coin of 6 cents and 1 coin of 5 cents
For t[0][0] : 
Think of it as you would first look at the bag of coins and 
then the value of the sum, if you have no coins in the bag, you 
need not to look at the sum, it would definitely be INT_MAX or INT_MAX-1 
(to avoid overflow)
*/
public class CoinChangeMinCoins {
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
		int noOfWays = minimumNoofCoins(coins, n, sum);
		System.out.println("The minimum no of coins is :" + noOfWays);
	}

	private static int minimumNoofCoins(int[] coins, int n, int sum) {
		int t[][] = new int[n+1][sum+1];
		int infinity = Integer.MAX_VALUE-1;
		//Initialization
		for(int size=0;size<=n;size++)
			for(int total =0;total<=sum;total++)
			{
				if(size == 0)
					t[size][total] = infinity-1;
				if(total == 0)
					t[size][total] = 0;
			}
		// Building remaining table
		for(int size=1;size<=n;size++)
			for(int total =1;total<=sum;total++)
			{
				if(coins[size-1]<=total)
					t[size][total] = Math.min(1+t[size/*Unbounded no -1*/][total-coins[size-1]] , t[size-1][total]);
				else
					t[size][total] =  t[size-1][total];
			}
		
		// final result
		return t[n][sum];
	}
}
