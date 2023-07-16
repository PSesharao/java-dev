package integratedmttaxi6;

public class Taxi {
	private String taxiNumber;
	private String driverFirstName;
	private int driverID;
	private int taxiDistance;

	public Taxi(String taxiNumber, String driverFirstName, int driverID, int taxiDistance) {
		this.taxiNumber = taxiNumber;
		this.driverFirstName = driverFirstName;
		this.driverID = driverID;
		this.taxiDistance = taxiDistance;
	}

	public String getTaxiNumber() {
		return taxiNumber;
	}

	public void setTaxiNumber(String taxiNumber) {
		this.taxiNumber = taxiNumber;
	}

	public String getDriverFirstName() {
		return driverFirstName;
	}

	public void setDriverFirstName(String driverFirstName) {
		this.driverFirstName = driverFirstName;
	}

	public int getDriverID() {
		return driverID;
	}

	public void setDriverID(int driverID) {
		this.driverID = driverID;
	}

	public int getTaxiDistance() {
		return taxiDistance;
	}

	public void setTaxiDistance(int taxiDistance) {
		this.taxiDistance = taxiDistance;
	}

	public void displayTaxi() {
		System.out.println("taxiNumber:\t" + this.getTaxiNumber());
		System.out.println("driverFirstName:" + this.getDriverFirstName());
		System.out.println("driverID:\t" + this.getDriverID());
		System.out.println("taxiDistance:\t" + this.getTaxiDistance());
	}
}
