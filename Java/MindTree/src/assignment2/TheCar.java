package assignment2;
import java.util.ArrayList;
import java.util.Scanner;
public class TheCar {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// adding first car 
		System.out.println("Enter capacity of car1 :");
		int capacity1 = sc.nextInt();
		Car car1 = new Car();
		car1.setCapacity(capacity1);
		System.out.println("Enter expected number of people :");
		int expnbppl1 = sc.nextInt();
		String wkdays1[] = new String[3];
		wkdays1[0] = "Saturday";
		wkdays1[1] = "Tuesday";
		wkdays1[2] = "Thursday";
		CarBooking cb1 = new CarBooking(car1, expnbppl1, wkdays1);
		CarBookingList clst = new CarBookingList();
		clst.addCarBooking(cb1);
		// Adding 2nd car 
		System.out.println("Enter capacity of car2 :");
		int capacity2 = sc.nextInt();
		Car car2 = new Car();
		car2.setCapacity(capacity2);
		System.out.println("Enter expected number of people :");
		int expnbppl2 = sc.nextInt();
		String wkdays2[] = new String[2];
		wkdays2[0] = "Wednesday";
		wkdays2[1] = "Monday";
		CarBooking cb2 = new CarBooking(car2, expnbppl2, wkdays2);
		clst.addCarBooking(cb2);
		System.out.println(cb1.noOfBookingDays());
		System.out.println(cb2.noOfBookingDays());
		System.out.println(cb1.validateCapacity());
		System.out.println(cb2.validateCapacity());
		cb1.alterExpectedNbPeople(12);
		cb2.alterExpectedNbPeople(20);
		sc.close();
	}
}
class CarBookingList
{
	private ArrayList<CarBooking> carBookingList;
	public CarBookingList() {
		this.carBookingList = new ArrayList<CarBooking>();
	}
	public void addCarBooking (CarBooking cb) {
		carBookingList.add(cb);
	}
}
class CarBooking
{
	private Car car;
	private int expectedNbPeople;
	private String weekDays[];
	public CarBooking(Car car, int expectedNbPeople, String[] weekDays) {
		this.car = car;
		this.expectedNbPeople = expectedNbPeople;
		this.weekDays = weekDays;
	}
	public void alterExpectedNbPeople(int newExpectedNbPeople)
	{
		this.expectedNbPeople = newExpectedNbPeople;
	}
	public boolean validateCapacity()
	{
		if(this.expectedNbPeople<car.getCapacity())
			return true;
		else
			return false;
	}
	public int noOfBookingDays()
	{
		return this.weekDays.length;
	}
}
class Car
{
	private int capacity;

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}