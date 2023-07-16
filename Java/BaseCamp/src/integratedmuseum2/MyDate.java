package integratedmuseum2;

public class MyDate {
	String date;

	public MyDate(String date) {
		this.date = date;
	
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public int getYears() {
		return (getDate().charAt(6) - '0') * 10 + (getDate().charAt(7) - '0') + (getDate().charAt(8) - '0') * 10
				+ (getDate().charAt(9) - '0');
	}

	public int getMonths() {
		return (getDate().charAt(3) - '0') * 10 + (getDate().charAt(4) - '0');
	}

	public int getDays() {
		return (getDate().charAt(0) - '0') * 10 + (getDate().charAt(1) - '0');
	}

}
