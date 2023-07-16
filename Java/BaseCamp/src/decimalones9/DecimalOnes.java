
package decimalones9;

public class DecimalOnes {
	private long number;

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public DecimalOnes(long number) {
		this.number = number;
	}
	
	public int Ones()
	{
		long ones = 0;
		int noOfDigits = 0;
		do
		{
			ones = (ones*10+1)%number;
			noOfDigits++;
		}while(ones!=0);
		return noOfDigits;
	}
}
