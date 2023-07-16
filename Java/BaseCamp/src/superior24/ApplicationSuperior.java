package superior24;

import java.util.Scanner;

public class ApplicationSuperior {
	private static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		ApplicationSuperior supApp = new ApplicationSuperior();
		supApp.driverMethod();
	}
	private void driverMethod() {
		int rows, cols,rowIndex=-1,colIndex=-1;
		int superior = -1;
		int mat[][];
		System.out.println("Enter number of rows of matrix:");
		rows = getValidatedPositiveInteger();
		System.out.println("Enter number of cols of matrix:");
		cols = getValidatedPositiveInteger();
		mat = new int[rows][cols];
		System.out.println("Enter  matrix :" + (rows) + "X" + (cols));
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				mat[i][j] = getValidatedPositiveInteger();
		Matrix matrix = new Matrix(mat, rows, cols);
		System.out.println("The entered matrix :");
		matrix.printMatrix();
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				if(superior < mat[i][j])
				{
					superior = mat[i][j] ;
					rowIndex =i;
					colIndex = j;
				}
		System.out.println("The superior element "+superior +" is found at position "+"["+rowIndex+","+colIndex+"]");
	}
	
	public int getValidatedPositiveInteger() {
		int number;
		do {
			while (!input.hasNextInt()) {
				String userInput = input.next();
				System.out.printf("\"%s\" is not a valid number,try again.\nEnter a positive integer :", userInput);
			}
			number = input.nextInt();
			if (number < 0)
				System.out.println("You have entered a negative number " + number + " try again.");
		} while (number < 0);
		return number;
	}
}
