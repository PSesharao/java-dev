package integratedtravelagent5;

public class Traveller {
	private String firstName;
	private String mobileNumber;
	private String typeOfJourney;
	private String airline;
	private MyDate depatureTime;
	private MyDate arrivalTime;
	private String source;
	private String destination;

	public Traveller(String firstName, String mobileNumber, String typeOfJourney, String airline, MyDate depatureTime,
			MyDate arrivalTime, String source, String destination) {
		this.firstName = firstName;
		this.mobileNumber = mobileNumber;
		this.typeOfJourney = typeOfJourney;
		this.airline = airline;
		this.depatureTime = depatureTime;
		this.arrivalTime = arrivalTime;
		this.source = source;
		this.destination = destination;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getTypeOfJourney() {
		return typeOfJourney;
	}

	public void setTypeOfJourney(String typeOfJourney) {
		this.typeOfJourney = typeOfJourney;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public MyDate getDepatureTime() {
		return depatureTime;
	}

	public void setDepatureTime(MyDate depatureTime) {
		this.depatureTime = depatureTime;
	}

	public MyDate getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(MyDate arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
}
