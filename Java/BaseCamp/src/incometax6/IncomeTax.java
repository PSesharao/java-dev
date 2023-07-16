package incometax6;

public class IncomeTax {
	private int earningOfEmployee;

	public int getEarningOfEmployee() {
		return earningOfEmployee;
	}

	public void setEarningOfEmployee(int earningOfEmployee) {
		this.earningOfEmployee = earningOfEmployee;
	}

	public IncomeTax(int earningOfEmployee) {
		this.earningOfEmployee = earningOfEmployee;
	}

	public double calculateIncomeTax() {
		double taxToBePaid;
		int additionalAmount;
		if (earningOfEmployee <= 50000)
			taxToBePaid = 0;
		else if (earningOfEmployee > 50000 && earningOfEmployee <= 60000) {
			additionalAmount = earningOfEmployee - 50000;
			taxToBePaid = additionalAmount * 0.1;
		} else if (earningOfEmployee > 60000 && earningOfEmployee <= 150000) {
			additionalAmount = earningOfEmployee - 60000;
			taxToBePaid = additionalAmount * 0.2;
		} else {
			additionalAmount = earningOfEmployee - 150000;
			taxToBePaid = additionalAmount * 0.3;
		}
		return taxToBePaid;
	}
}
