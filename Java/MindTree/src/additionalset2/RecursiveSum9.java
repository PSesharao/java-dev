package additionalset2;

import java.util.Scanner;

public class RecursiveSum9 {
	private static int calculateSum(int arr[], int n) {
		 
        //base or terminating condition
        if (n <= 0) {
           return 0;
         }

         //Calling method recursively
         return calculateSum(arr, n-1 ) + arr[n-1];
      }

     public static void main(String[] args) {

        int arr[] ;
        int l;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of array :");
        l= sc.nextInt();
        arr = new int[l];
        System.out.println("Enter the elements into array :");
        for(int i=0;i<l;i++)
        	arr[i] = sc.nextInt();
        sc.close();
        int sum = calculateSum(arr, arr.length);

         System.out.println(sum);
     }
}
