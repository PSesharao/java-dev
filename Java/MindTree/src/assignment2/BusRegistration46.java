package assignment2;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class BusRegistration46 {
	public static void main(String[] args) {
		Customers carray [] = new Customers[0];
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			int ch;
			System.out.println("1.Add customer details");
			System.out.println("2.Book a ticket");
			System.out.println("3.Display Customers");
			System.out.println("4.Exit");
			System.out.println("Please enter a choice from above :");
			ch = sc.nextInt();
			switch(ch)
			{
				case 1:
					System.out.println("Enter the following customer details :");
					System.out.println("Enter Id :");
					int id= sc.nextInt();
					System.out.println("Enter name :");
					String name = sc.next();
					System.out.println("Enter age :");
					int age = sc.nextInt();
					System.out.println("Enter mobile number :");
					String mobnum = sc.next();
					System.out.println("Enter dob :");
					String dob = sc.next();
					System.out.println("Enter address :");
					String address = sc.next();
					Customers customer = new Customers(id, name, age, mobnum, dob, address);
					carray = addCustomer(carray, customer);
					break ;
				case 2:
					System.out.println("Enter the following details for Ticket booking :");
					System.out.println("Enter ID :");
					int idT = sc.nextInt();
					System.out.println("Enter name :");
					String nameT = sc.next();
					System.out.println("Enter mobile number :");
					String mobilenumT = sc.next();
					System.out.println("Enter the source :");
					String sourceT = sc.next();
					System.out.println("Enter destination :");
					String destinationT = sc.next();
					System.out.println("Enter date & time in 'MM/dd/yyyy hh:mm a' format :");
					sc.nextLine();
					String date_timeT = sc.nextLine(); 
					BusTicketDetails ticket = new BusTicketDetails(idT, nameT, mobilenumT, sourceT, destinationT, date_timeT);
					if(BusTicketDetails.validateTicket(ticket, carray))
						System.out.println("Ticket Confirmed !!");
					else 
						System.out.println("Sorry ! Register again!");
					break ;
				case 3:
					System.out.println("Enter the city name of customer :");
					String city = sc.next();
					Customers.displayCustomersFromCity(carray, city);
					System.out.println("Enter customer Id :");
					int idC= sc.nextInt();
					Customers.displayCustomerWithId(carray, idC);
					System.out.println("Displaying customer names in sorted order :");
					Customers.sortCustomerNames(carray);
					break;
				case 4:
					System.out.println("Adieu Thanks!!!");
					System.exit(0);
					sc.close();
					break ;
				default :
					System.out.println("Enter the right choice");
			}
		}
	}
	public static Customers [] addCustomer(Customers carray [],Customers customer)
	{
		int currLen = carray.length;
		Customers [] temp = new  Customers [currLen+1];
		for(int i=0;i<currLen;i++)
			temp[i] = carray[i];
		temp[currLen] = customer;
		return temp;
	}
}
class BusTicketDetails
{
	private int id;
	private String name;
	private String mobile_number;
	private String source;
	private String destination;
	private String travel_date_time;
	
	public static boolean DoesContain(Customers[] carray,int id,String mobile_number)
	{
		int len = carray.length;
		for(int i=0;i<len;i++)
			if(carray[i].id==id && carray[i].mobile_number.equalsIgnoreCase( mobile_number)) 
				return true;
		return false;
	}
	public static boolean validateTicket(BusTicketDetails ticket,Customers[] carray)
	{
		boolean isValid = true;
		isValid = isValid && DoesContain(carray, ticket.id, ticket.mobile_number);
		String format = "MM/dd/yyyy hh:mm a";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		// getTime() returns the number of milliseconds since January 1, 1970, 00:00:00 GMT represented by this Date object
		Date dateobj = new Date();
		String present = sdf.format(dateobj);
		
		try {
			Date dateObj1 = sdf.parse(present);
			Date dateObj2 = sdf.parse(ticket.travel_date_time);
			long diff = dateObj2.getTime() - dateObj1.getTime();
			int diffDays = (int) (diff / (24 * 60 * 60 * 1000));
			if(diffDays>=1 && diffDays<=30) 
				isValid = isValid && true;
			else 
				isValid = isValid && false;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(ticket.source == ticket.destination)
			isValid = isValid && false;
		else 
			isValid = isValid && true;
		return isValid;
	}
	public BusTicketDetails(int id, String name, String mobile_number, String source, String destination,
			String travel_date_time) {
		this.id = id;
		this.name = name;
		this.mobile_number = mobile_number;
		this.source = source;
		this.destination = destination;
		this.travel_date_time = travel_date_time;
	}
}

class Customers
{
	public  int id;
	public String name;
	public int age;
	public String mobile_number;
	public String d_o_b;
	public String address;
	public Customers(int id, String name, int age, String mobile_number, String d_o_b, String address) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.mobile_number = mobile_number;
		this.d_o_b = d_o_b;
		this.address = address;
		
}
	public static void displayCustomersFromCity(Customers [] carray , String city)
	{
		int len = carray.length;
		for(int i=0;i<len;i++)
			if(carray[i].address.equalsIgnoreCase(city))
				System.out.println(carray[i]);
	}
	public static void displayCustomerWithId(Customers [] carray,int id)
	{
		int len = carray.length;
		for(int i=0;i<len;i++)
			if(carray[i].id==id)
				System.out.println(carray[i]);
	}
	public static void sortCustomerNames(Customers[] carray)
	{
		int len = carray.length;
		for(int i=0;i<len-1;i++)
			for(int j=0;j<len-1-i;j++)
				if(carray[j].name.compareTo(carray[j+1].name)>0)
				{
					Customers temp = carray[j];
					carray[j] = carray[j+1];
					carray[j+1] = temp;
				}
		for(int i=0;i<len;i++)
			System.out.println(carray[i].name);
	}
	@Override
	public String toString() {
		return "Customers [id=" + id + ", name=" + name + ", age=" + age + ", mobile_number=" + mobile_number
				+ ", d_o_b=" + d_o_b + ", address=" + address + "]";
	}
}
