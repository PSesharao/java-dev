package integratedsupermarket4;

public class Customer {
	private String firstName;
	private String mobileNumber;
	private Item itemsPurchased[];
	private int quantity[];

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

	public Item[] getItemsPurchased() {
		return itemsPurchased;
	}

	public void setItemsPurchased(Item[] itemsPurchased) {
		this.itemsPurchased = itemsPurchased;
	}

	public int[] getQuantity() {
		return quantity;
	}

	public void setQuantity(int[] quantity) {
		this.quantity = quantity;
	}

	public Customer(String firstName, String mobileNumber) {
		this.firstName = firstName;
		this.mobileNumber = mobileNumber;
	}

	public void displayCustomer() {
		System.out.println("firstName    :" + this.getFirstName());
		System.out.println("mobileNumber :" + this.getMobileNumber());
		System.out.println("itemcode\t\tquantity");
		for (int i = 0; i < this.getItemsPurchased().length; i++) {
			System.out.println(this.getItemsPurchased()[i].getItemCode() + "\t\t" + this.getQuantity()[i]);
		}
	}
}
