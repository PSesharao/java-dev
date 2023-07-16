package matrixmul13;

import java.util.Scanner;

public class ApplicationMultiplication {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		ApplicationMultiplication mulApp = new ApplicationMultiplication();
		mulApp.driverMethod();
	}

	private void driverMethod() {
		int rows1, cols1, rows2, cols2;
		int mat1[][], mat2[][], mat[][];
		boolean isValid;
		do {
			isValid = true;
			System.out.println("Enter number of rows of first matrix:");
			rows1 = getValidatedPositiveInteger();
			System.out.println("Enter number of cols of first matrix:");
			cols1 = getValidatedPositiveInteger();
			System.out.println("Enter number of rows of second matrix:");
			rows2 = getValidatedPositiveInteger();
			System.out.println("Enter number of cols of second matrix:");
			cols2 = getValidatedPositiveInteger();
			if (rows2 != cols1) {
				isValid = false;
				System.out
						.println("number of cols of first matrix should be equal to number of rows of second matrix!!");
				System.out.println("Try again");
			}
		} while (!isValid);
		mat1 = new int[rows1][cols1];
		System.out.println("Enter first matrix :" + (rows1) + "X" + (cols1));
		for (int i = 0; i < rows1; i++)
			for (int j = 0; j < cols1; j++)
				mat1[i][j] = input.nextInt();
		mat2 = new int[rows2][cols2];
		System.out.println("Enter second matrix :" + (rows2) + "X" + (cols2));
		for (int i = 0; i < rows2; i++)
			for (int j = 0; j < cols2; j++)
				mat2[i][j] = input.nextInt();
		mat = new int[rows1][cols2];
		for (int i = 0; i < rows1; i++)
			  for (int j = 0; j < cols2; j++)
				  for (int k = 0; k < cols1; k++)
					mat[i][j] += mat1[i][k] * mat2[k][j];
		Matrix matrix = new Matrix(mat, rows1, cols2);
		System.out.println("The multiplication is :");
		matrix.printMatrix();
	}

	public static int getValidatedPositiveInteger() {
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
