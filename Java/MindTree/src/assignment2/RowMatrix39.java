package assignment2;

import java.util.Scanner;

public class RowMatrix39 {
	public static boolean isRowMatrix(int m[][])
	{
		int rsum=0;
		for(int row=0;row<m[0].length;row++)
			rsum+=m[0][row];
		for(int row=0;row<m.length;row++)
		{
			int s=0;
			for(int col=0;col<m[0].length;col++)
				s+=m[row][col];
			if(s!=rsum)
				return false;
		}
	return true;		
				
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m[][],o;
		System.out.println("Enter the order of the matrix :");
		o=sc.nextInt();
		m=new int[o][o];
		System.out.println("Enter the elements of matrix :");
		for(int i=0;i<o;i++)
			for(int j=0;j<o;j++)
				m[i][j] = sc.nextInt();
		if(isRowMatrix(m))
			System.out.println("It's a Row Magic Square ");
		else
			System.out.println("It's not a Row Magic Square ");
		sc.close();
	}
}
