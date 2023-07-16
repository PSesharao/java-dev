package assignment2;
public class BankRegisration29 {
	public static void main(String[] args) {
		Customer customer1 = new Customer(1001, "Kumar", "Rajajinagar, Bangalore-10");
		Customer customer2 = new Customer(1002, "Raja");
		Customer customer3 = new Customer(1003, "Shanthi", "Jayanagar, Bangalore-20", "SB", 1500);
		customer1.displayCustomer();
		customer2.displayCustomer();
		customer3.displayCustomer();
	}
}
class Customer
{
	private int custId;
	private String custName; 
	private String custAddress;
	private String accType;
	private double custBalance;
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public double getCustBalance() {
		return custBalance;
	}
	public void setCustBalance(double custBalance) {
		this.custBalance = custBalance;
	}
	public Customer(int custId, String custName, String custAddress, String accType, double custBalance) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custAddress = custAddress;
		this.accType = accType;
		this.custBalance = custBalance;
	}
	public Customer(int custId, String custName, String custAddress) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custAddress = custAddress;
	}
	public Customer(int custId, String custName) {
		super();
		this.custId = custId;
		this.custName = custName;
	}
	public void displayCustomer()
	{
		System.out.println("Customer Information");
		System.out.println("Name :"+this.getCustName());
		System.out.println("Id :"+this.getCustId());
		if(this.getCustAddress()!=null)
			System.out.println("Address :"+this.getCustAddress());
		if(this.getAccType()!=null)
			System.out.println("Account Type :"+this.getAccType());
		if(this.getCustBalance()!=0)
			System.out.println("Account Balance :"+this.getCustBalance());
	}
}
