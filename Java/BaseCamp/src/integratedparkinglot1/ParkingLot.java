package integratedparkinglot1;

public class ParkingLot {
	private boolean available;
	private String vehicleNumber;
	private MyDate entryTime;
	public ParkingLot(String vehicleNumber, MyDate entryTime) {
		this.vehicleNumber = vehicleNumber;
		this.entryTime = entryTime;
	}
	public ParkingLot(boolean available)
	{
		this.available = available;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public MyDate getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(MyDate entryTime) {
		this.entryTime = entryTime;
	}

}
