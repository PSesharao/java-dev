package course;

public class Student {
	private String firstName;
	private int age;
	private String gender;
	private String address;
	private String courseName;
	private String mobileNumber;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Student(String firstName, int age, String gender, String address, String courseName, String mobileNumber) {
		this.firstName = firstName;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.courseName = courseName;
		this.mobileNumber = mobileNumber;
	}
	public void displayStudent()
	{
		System.out.println("firstName :"+this.getFirstName());
		System.out.println("age :"+this.getAge());
		System.out.println("gender :"+this.getGender());
		System.out.println("address :"+this.getAddress());
		System.out.println("courseName :"+this.getCourseName());
		System.out.println("mobileNumber :"+this.getMobileNumber());
	}
}
