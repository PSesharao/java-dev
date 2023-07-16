package binaryzero8;

public class BinaryZeros {
	private int number;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public BinaryZeros(int number) {
		this.number = number;
	}
	public int noOfBinaryZeros()
	{
		int zeroCount = 0;
		int remainder;
		while(number!=0)
		{
			remainder = number%2;
			if(remainder==0)	zeroCount++;
			number/=2;
		}
		return zeroCount;
	}
	
}
