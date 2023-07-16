package additionalset2;

import java.util.Scanner;

public class RecursiveFibonnaci8 {
	public static int fibonacciRecursion(int n){
		if(n == 0){
			return 0;
		}
		if(n == 1 || n == 2){
				return 1;
			}
		return fibonacciRecursion(n-2) + fibonacciRecursion(n-1);
		}
	    public static void main(String args[]) {
		int maxNumber ;
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Enter the no of terms :");
		maxNumber=sc.nextInt();
		sc.close();
		System.out.print("Fibonacci Series of "+maxNumber+" numbers: ");
		for(int i = 0; i < maxNumber; i++){
				System.out.print(fibonacciRecursion(i) +" ");
			}
		}
}
