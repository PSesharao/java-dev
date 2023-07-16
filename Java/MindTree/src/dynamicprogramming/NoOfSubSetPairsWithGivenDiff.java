package dynamicprogramming;

import java.util.Scanner;
/* If arr[] = {1,1,2,3} , diff = 1
   we have 1) {1,3} - {1,2}
   		   2) {1,3} - {1,2}
   		   3) {1,1,2} - {3}
   	3 such a subsets possible here.
   	let's suppose s1 - s2 = diff
   	              s1 + s2  = sum
   	              2xs1  = diff + sum 
   	              s1 = (diff + sum) / 2
   	so we have to calculate s1 sum count . 
   	one more condition needs to be checked i.e.if((S+sum)%2!=0)  
   	then  we would never get the difference S by partitioning the 
   	array into two subsets.
 */
public class NoOfSubSetPairsWithGivenDiff {
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
				if(array[size-1]<=total)
					t[size][total] = t[size-1][total-array[size-1]] + t[size-1][total];
				else
					t[size][total] =  t[size-1][total];
			}
		
		// final result
		return t[n][sum];
	}
}
