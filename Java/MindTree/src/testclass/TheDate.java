package testclass;

public class TheDate {
	String date;
	String time;

	public TheDate(String date, String time) {
		this.date = date;
		this.time = time;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
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

	public int getMinutes() {
		return (getTime().charAt(3) - '0') * 10 + (getTime().charAt(4) - '0');
	}

	public int getHours() {
		return (getTime().charAt(0) - '0') * 10 + (getTime().charAt(1) - '0');
	}
}
