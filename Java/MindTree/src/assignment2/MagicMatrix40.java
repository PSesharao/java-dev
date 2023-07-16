package assignment2;

import java.util.Scanner;

public class MagicMatrix40 {
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
	public static boolean isColMatrix(int m[][])
	{
		int csum=0;
		for(int col=0;col<m.length;col++)
			csum+=m[col][0];
			for(int col=0;col<m[0].length;col++)
			{
				int s=0;
				for(int row=0;row<m.length;row++)
					s+=m[col][row];
				if(s!=csum)
					return false;
			}
	return true;		
				
	}
	public static boolean isDiagMatrix(int m[][])
	{
		int ldiagsum=0,rdiagsum=0,order=m.length;
		for(int i=0;i<order;i++)
		{
			ldiagsum+=m[i][i];
			rdiagsum+=m[i][order-1-i];
		}
		if(ldiagsum!=rdiagsum)	
			return false;
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
		if(isRowMatrix(m) && isColMatrix(m) && isDiagMatrix(m))
			System.out.println("It's a Magic Square ");
		else
			System.out.println("It's not a Magic Square ");
		sc.close();
	}
}
