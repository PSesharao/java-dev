package datastructures;
import java.util.Scanner;
public class Array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int array[] = new int[5];
		for(int i=0;i<array.length;i++)
		{
			System.out.println("Enter the value for "+(i+1)+" index");
			array[i] = sc.nextInt();
		}
		for(int k : array)
		{
			System.out.println("The values of array are :"+k);
		}
		sc.close();
	}
}
