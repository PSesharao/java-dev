package integratedmuseum2;

public class MuseumData {
	private String firstName;
	private int age;
	private String gender;
	private MyDate dateOfEntry;

	public MyDate getDateOfEntry() {
		return dateOfEntry;
	}

	public void setDateOfEntry(MyDate dateOfEntry) {
		this.dateOfEntry = dateOfEntry;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public MuseumData(String firstName, int age, String gender, MyDate dateOfEntry) {
		this.firstName = firstName;
		this.age = age;
		this.gender = gender;
		this.dateOfEntry = dateOfEntry;
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

	public int calculateEntryFee() {
		if (this.getAge() < 5)
			return 0;
		else if (this.getAge() >= 5 && this.getAge() < 18)
			return 10;
		else if (this.getAge() >= 18 && this.getAge() < 60)
			return 20;
		else
			return 5;
	}

	public void displayMuseumEntry() {
		System.out.println("Name :" + this.getFirstName());
		System.out.println("Age :" + this.getAge());
		System.out.println("Gender :" + this.getGender());
		System.out.println("Date of entry :"+this.getDateOfEntry().getDate());
	}
}
