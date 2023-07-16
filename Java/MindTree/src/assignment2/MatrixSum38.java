package assignment2;

import java.util.Scanner;

public class MatrixSum38 {
	public static void main(String[] args) {
		int a[][];
		int b[][];
		int c[][];
		int o;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the order of the matrix :");
		o=sc.nextInt();
		a=new int[o][o];
		b=new int[o][o];
		c=new int[o][o];
		System.out.println("Enter first matrix :");
		for(int r=0;r<o;r++)
			for(int col=0;col<o;col++)
				a[r][col]=sc.nextInt();
		System.out.println("Enter 2nd matrix :");
		for(int r=0;r<o;r++)
			for(int col=0;col<o;col++)
				b[r][col]=sc.nextInt();
		System.out.println("The resultant matrix is :");
		for(int r=0;r<o;r++)
			for(int col=0;col<o;col++)
				c[r][col]=a[r][col]+b[r][col];
		for(int r=0;r<o;r++) {
			for(int col=0;col<o;col++)
				System.out.print(c[r][col]+" ");
			System.out.println();
		}
		sc.close();
	}
}
