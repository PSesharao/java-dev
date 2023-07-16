package dynamicprogramming;
import java.util.Scanner;
/* Sum of subset differences
Given a set of integers, the task is to divide it into two sets S1 and S2 such that the 
absolute difference between their sums is minimum.
If there is a set S with n elements, then if we assume Subset1 has m elements, 
Subset2 must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.
Example:
Input:  arr[] = {1, 6, 11, 5} 
Output: 1
Explanation:
Subset1 = {1, 5, 6}, sum of Subset1 = 12 
Subset2 = {11}, sum of Subset2 = 11 */
/*I think there is an easier way to explain this problem assume the total sum of array is S 
now the min difference that we can achieve is 0 when we can get 2 subsets with sum s1 and s2
such that s1+s2 = S this is when s1=S/2 
Let's suppose limit is S/2 so now we have to maximize s1 such that  s1<=limit the closer s1 
can get to the limit the minimum the difference will be between s1 and s2 so now its a standard
knapsack problem where limit denotes capacity and s1 denotes how much of knapsack is filled*/
public class MinimumSubSetSumDiff {
	static boolean t[][] ;//= new boolean[102][1002];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array :");
		int n,array[],sum=0;
		n=sc.nextInt();
		array = new int[n];
		System.out.println("Enter "+n+" elements into array :");
		for(int i=0;i<n;i++) {
			array[i] = sc.nextInt();
			sum += array[i];
		}
		System.out.println(minimumSubSetSumDiff(array,sum,n));
		sc.close();
	}
	private static int minimumSubSetSumDiff(int [] array,int sum,int n) {
		t= new boolean[n+1][sum+1];
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
		// Consider the last row of table upto half. 
		int difference = -1;
		for(int total = sum/2;total >= 0;total--)// first half 
		{
			if(t[n][total] == true) // last row 
				{
				difference = sum - 2 * total;
				break;      // select the first true total
				}
		}
		return difference;
	}
}
