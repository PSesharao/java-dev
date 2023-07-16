package integratedmttaxi6;

public class Passenger {
	private String firstName;
	private int age;
	private String gender;
	private String mobileNumber;
	private int passengerDistance;

	public Passenger(String firstName, int age, String gender, String mobileNumber, int passengerDistance) {
		this.firstName = firstName;
		this.age = age;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.passengerDistance = passengerDistance;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getPassengerDistance() {
		return passengerDistance;
	}

	public void setPassengerDistance(int passengerDistance) {
		this.passengerDistance = passengerDistance;
	}

}
