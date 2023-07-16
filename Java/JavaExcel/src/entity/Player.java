package entity;

public class Player {
	private String firstName;
	private String lastName;
	private int jersyNumber;

	public Player(String firstName, String lastName, int jersyNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.jersyNumber = jersyNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getJersyNumber() {
		return jersyNumber;
	}

	public void setJersyNumber(int jersyNumber) {
		this.jersyNumber = jersyNumber;
	}

}
