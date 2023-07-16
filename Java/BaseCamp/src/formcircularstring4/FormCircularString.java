package formcircularstring4;

public class FormCircularString {
	private String inputString;
	private int inputNumber;

	public FormCircularString(String inputString, int inputNumber) {
		this.inputString = inputString;
		this.inputNumber = inputNumber;
	}

	public String getInputString() {
		return inputString;
	}

	public void setInputString(String inputString) {
		this.inputString = inputString;
	}

	public int getInputNumber() {
		return inputNumber;
	}

	public void setInputNumber(int inputNumber) {
		this.inputNumber = inputNumber;
	}

	public String[] generateCircularStrings() {
		String cirularStrings[] = new String[0];
		String circularString;
		String concatString = inputString + inputString;
		for (int curr = 0; curr < inputString.length(); curr++) {
			circularString = "";
			for (int next = curr; next < curr+inputNumber; next++)
				circularString += concatString.charAt(next);
			cirularStrings = addString(cirularStrings, circularString);
		}
		return cirularStrings;
	}

	public String[] addString(String cirularStrings[], String circularString) {
		int currLen = cirularStrings.length;
		String temp[] = new String[currLen + 1];
		for (int i = 0; i < currLen; i++)
			temp[i] = cirularStrings[i];
		temp[currLen] = circularString;
		return temp;
	}

	public String[] generateDistinctCircularStrings(String[] cirularStrings) {
		String distinctCircularArray[] = new String[0];
		int curr, prev;
		for (curr = 0; curr < cirularStrings.length; curr++) {
			for (prev = 0; prev < curr; prev++)
				if (cirularStrings[curr].compareTo(cirularStrings[prev]) == 0)
					break;
			if (curr == prev)
				distinctCircularArray = addString(distinctCircularArray, cirularStrings[curr]);
		}
		return distinctCircularArray;
	}

}
