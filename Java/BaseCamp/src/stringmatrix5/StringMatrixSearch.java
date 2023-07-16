package stringmatrix5;

import java.util.Scanner;

public class StringMatrixSearch {
	private char stringMatrix[][];

	private int dimension;

	public static Scanner input = new Scanner(System.in);

	public StringMatrixSearch(char[][] stringMatrix, int dimension) {
		this.stringMatrix = stringMatrix;
		this.dimension = dimension;
	}

	public char[][] getStringMatrix() {
		return stringMatrix;
	}

	public void setStringMatrix(char[][] stringMatrix) {
		this.stringMatrix = stringMatrix;
	}

	public int getDimension() {
		return dimension;
	}

	public void setDimension(int dimension) {
		this.dimension = dimension;
	}

	public boolean doesExistInRows(String inputString) {
		String alongRows;
		for (int row = 0; row < dimension; row++) {
			alongRows = "";
			for (int col = 0; col < dimension; col++)
				alongRows += stringMatrix[row][col];

			if (alongRows.indexOf(inputString) != -1)
				return true;
		}
		return false;
	}

	public boolean doesExistInCols(String inputString) {
		String alongCols;
		for (int col = 0; col < dimension; col++) {
			alongCols = "";
			for (int row = 0; row < dimension; row++)
				alongCols += stringMatrix[row][col];

			if (alongCols.indexOf(inputString) != -1)
				return true;
		}
		return false;
	}

	public boolean doesExistInLeftLowerTriangle(String inputString) {
		String alongLowerTriangle;
		int r, c;
		for (int row = 1; row < dimension; row++) {
			r = row;
			c = 0;
			alongLowerTriangle = "";
			while (r < dimension && c < dimension)
				alongLowerTriangle += stringMatrix[r++][c++];

			if (alongLowerTriangle.indexOf(inputString) != -1)
				return true;
		}
		return false;
	}

	public boolean doesExistInLeftUpperTriangle(String inputString) {
		String alongUpperTriangle;
		int r, c;
		for (int col = 0; col < dimension; col++) {
			r = 0;
			c = col;
			alongUpperTriangle = "";
			while (r < dimension && c < dimension)
				alongUpperTriangle += stringMatrix[r++][c++];
			if (alongUpperTriangle.indexOf(inputString) != -1)
				return true;
		}
		return false;
	}

	public String getValidatedFillString() {
		String fillString;
		int lengthOfFillStr;
		do {
			System.out.println("Enter a string :");
			fillString = input.next();
			lengthOfFillStr = fillString.length();
			if (lengthOfFillStr > dimension)
				System.out.println("Overflow,Try again!");
			else if (lengthOfFillStr < dimension)
				System.out.println("Underflow,Try again!");
			else
				System.out.println("Your string is filled in the matrix");
		} while (lengthOfFillStr != dimension);
		return fillString;
	}

	public String getValidatedSearchString() {
		String searchString;
		int lengthOfSearchStr;
		do {
			System.out.println("Enter a string :");
			searchString = input.next();
			lengthOfSearchStr = searchString.length();
			if (lengthOfSearchStr > dimension)
				System.out.println("Overflow,Try again!");
			else
				System.out.println("Your string will be searched in the matrix");
		} while (lengthOfSearchStr > dimension);
		return searchString;
	}
	
	public static int getValidatedPositiveInteger() {
		int number;
		do {
			System.out.println("Enter a positive integer :");
			while (!input.hasNextInt()) {
				String userInput = input.next();
				System.out.printf("\"%s\" is not a valid number,try again.\nEnter a positive integer :", userInput);
			}
			number = input.nextInt();
			if (number < 0)
				System.out.println("You have entered a negative number " + number + " try again.");
		} while (number < 0);
		System.out.printf("You have entered a positive number %d.\n", number);

		return number;
	}
	
	public void fillMatrix()
	{
		String fillString;
		for(int row=0;row<dimension;row++)
		{
			System.out.println("Enter "+"row "+(row+1));
			fillString = getValidatedFillString();
			for(int col=0;col<dimension;col++)
				stringMatrix[row][col] = fillString.charAt(col);
		}
	}
	
	public void printMatrix()
	{
		for(int row=0;row<dimension;row++)
		{
			for(int line=0;line<dimension*4+1;line++)
			System.out.print('-');
			System.out.println();
			for(int col=0;col<dimension;col++)
				System.out.printf("| %c ",stringMatrix[row][col]);
			System.out.println("|");
		}
		for(int line=0;line<dimension*4+1;line++)
			System.out.print('-');
			System.out.println();
	}
}
