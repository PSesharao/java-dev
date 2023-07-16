package sortingnames;

public class SortNames {
	private String firstName;
	private String secondName;

	public SortNames(String firstName, String secondName) {
		this.firstName = firstName;
		this.secondName = secondName;
	}

	public SortNames() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String[] splitNames(String fullName) {
		String temp = "";
		String[] nameSplit = new String[2];
		int len = 0;
		for (int index = 0; index < fullName.length(); index++) {
			if (fullName.charAt(index) == ' ' || (index == fullName.length() - 1)) {
				if (index == fullName.length() - 1) {
					temp += fullName.charAt(index);
					nameSplit[len++] = temp;
				} else {
					nameSplit[len++] = temp;
					temp = "";
				}
			} else
				temp += fullName.charAt(index);
		}
		return nameSplit;
	}

	public void insertionSortStringArray(SortNames[] theArray) {
		int arraySize = theArray.length;
		for (int i = 1; i < arraySize; i++) {
			int j = i;
			SortNames toInsert = theArray[i];
			while ((j > 0) && (theArray[j - 1].getFirstName().compareTo(toInsert.getFirstName()) > 0)) {
				theArray[j] = theArray[j - 1];
				j--;
			}
			theArray[j] = toInsert;
		}
	}

	public void printTable(SortNames[] array) {
		int len = array.length;
		System.out.println("-------------------------------------");
		for (int i = 0; i < len; i++) {
			System.out.printf("| %2d  |", (i + 1));
			System.out.printf("%30s|\n", array[i].getFirstName() + " " + array[i].getSecondName());
			System.out.println("-------------------------------------");
		}
	}
}
