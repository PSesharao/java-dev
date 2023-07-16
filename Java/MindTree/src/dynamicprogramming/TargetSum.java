package dynamicprogramming;

import java.util.Scanner;

/*Given a list of non-negative integers, a1, a2, ..., an, and a target, S. 
Now you have 2 symbols + and -. For each integer, you should choose 
one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal 
to target S.

Example 1:
Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.

By multiplying pow(2,cnt), it will consider all the 
subsets of 0 which was not considered earlier in no of subset pairs problem.
*/
public class TargetSum {
	static int t[][];// = new int[102][1002];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array :");
		int n,array[],sum = 0;
		n=sc.nextInt();
		array = new int[n];
		System.out.println("Enter "+n+" elements into array :");
		for(int i=0;i<n;i++) { 
			array[i] = sc.nextInt();
			sum += array[i]; 
		}
		System.out.println("Enter the difference :");
		int diff = sc.nextInt();
		if((sum+diff)%2==0 && diff <= sum) {
		int s1  = (sum + diff)/2;
		System.out.println(noOfSubsetsWithsum(array, s1, n));
		}
		else
			System.out.println(0);
		sc.close();
	}
	public static int noOfSubsetsWithsum(int array[],int sum,int n)
	{
		int noOfZero = 0;
		for(int i=0;i<n;i++)
			if(array[i]==0)
				noOfZero++;
		t = new int[n+1][sum+1];
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
				if(array[size-1]==0)
					t[size][total]= t[size-1][total];
				else if(array[size-1]<=total)
					t[size][total] = t[size-1][total-array[size-1]] + t[size-1][total];
				else
					t[size][total] =  t[size-1][total];
			}
		
		// final result
		return (int) (Math.pow(2, noOfZero)*t[n][sum]);
	}
}
