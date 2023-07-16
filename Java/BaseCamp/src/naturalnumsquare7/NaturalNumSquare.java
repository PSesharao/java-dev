package naturalnumsquare7;

public class NaturalNumSquare {
	private int arraySize;
	private int theArray[];

	public int getArraySize() {
		return arraySize;
	}

	public void setArraySize(int arraySize) {
		this.arraySize = arraySize;
	}

	public int[] getTheArray() {
		return theArray;
	}

	public void setTheArray(int[] theArray) {
		this.theArray = theArray;
	}

	public NaturalNumSquare(int arraySize, int[] theArray) {
		this.arraySize = arraySize;
		this.theArray = theArray;
	}

	public int[] computeSquare() {
		int theSquares[] = new int[arraySize];

		for (int i = 0; i < arraySize; i++)
			theSquares[i] = theArray[i] * theArray[i];

		return theSquares;
	}
}
