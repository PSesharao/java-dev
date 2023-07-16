package stringmatrix5;

public class ApplicationMenu {
	public static void main(String[] args) {
		char stringMatrix[][];
		int dimension;
		String searchString;
		int choice;
		StringMatrixSearch callObject = null;
		do {
			choice = createMenu();
			switch (choice) {
			case 1:
				System.out.println("Enter the dimension of square matrix :");
				dimension = StringMatrixSearch.getValidatedPositiveInteger();
				stringMatrix = new char[dimension][dimension];
				callObject = new StringMatrixSearch(stringMatrix, dimension);
				break;
			case 2:
				if (callObject != null) {
					callObject.fillMatrix();
					callObject.printMatrix();
				} else
					System.out.println("The matrix is not intialized.");
				break;
			case 3:
				System.out.println("Enter the string to be searched in matrix :");
				searchString = callObject.getValidatedSearchString();
				callObject.printMatrix();
				if (callObject.doesExistInRows(searchString))
					System.out.println("The string " + "\"" + searchString + "\"" + " exist in one of rows");
				else
					System.out.println("The string " + "\"" + searchString + "\"" + " does not exist in any of rows");
				if (callObject.doesExistInCols(searchString))
					System.out.println("The string " + "\"" + searchString + "\"" + " exist in one of columns");
				else
					System.out
							.println("The string " + "\"" + searchString + "\"" + " does not exist in any of columns");

				if (callObject.doesExistInLeftLowerTriangle(searchString)
						|| callObject.doesExistInLeftUpperTriangle(searchString))
					System.out.println("The string " + "\"" + searchString + "\"" + " exist in one of diagonals");
				else
					System.out.println(
							"The string " + "\"" + searchString + "\"" + " does not exist in any of diagonals");
				break;
			case 4:
				System.out.println("Exiting!");
				break;
			default:
				System.out.println("Enter the right choice:");
			}

		} while (choice != 4);
	}

	public static int createMenu() {
		int choice;
		System.out.println("Enter your choice:");
		System.out.println("1. Get the dimensions for a square matrix");
		System.out.println("2. Fill the matrix with characters");
		System.out.println("3. Get a string from the user to be searched in the matrix");
		System.out.println("4. Exit");
		choice = getValidatedInteger();
		return choice;
	}

	public static int getValidatedInteger() {
		int number;

		System.out.println("Enter an integer :");
		while (!StringMatrixSearch.input.hasNextInt()) {
			String userInput = StringMatrixSearch.input.next();
			System.out.printf("\"%s\" is not a valid number,try again.\nEnter an integer :", userInput);
		}
		number = StringMatrixSearch.input.nextInt();
		System.out.printf("You have entered a number %d.\n", number);
		return number;
	}

}
