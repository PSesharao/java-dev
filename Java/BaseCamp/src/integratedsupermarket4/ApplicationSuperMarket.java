package integratedsupermarket4;

import java.util.Scanner;

public class ApplicationSuperMarket {
	private static Scanner input = new Scanner(System.in);
	private static ApplicationSuperMarket appSupMark = new ApplicationSuperMarket();

	public static void main(String[] args) {
		appSupMark.driverMethod();
	}

	private void driverMethod() {
		final int noOfItems = 5;
		Item itemsRecord[] = new Item[noOfItems];
		itemsRecord[0] = new Item("MTree101", 110, 10);
		itemsRecord[1] = new Item("MTree102", 120, 12);
		itemsRecord[2] = new Item("MTree103", 150, 20);
		itemsRecord[3] = new Item("MTree104", 175, 25);
		itemsRecord[4] = new Item("MTree105", 200, 30);
		Customer customersRecord[] = new Customer[0];
		Customer customerEntry;
		int choice;
		int prevHistory;
		String firstName;
		String mobileNumber;
		do {
			choice = createMenu();
			switch (choice) {
			case 1:
				boolean continueShopping;
				firstName = getValidatedInput("firstName");
				mobileNumber = getValidatedInput("mobileNumber");
				prevHistory = getCustomerPrevRecord(customersRecord, mobileNumber);
				if (prevHistory == -1) {
					customerEntry = new Customer(firstName, mobileNumber);
					customersRecord = addEntry(customersRecord, customerEntry);
					customerEntry.setItemsPurchased(new Item[0]);
					customerEntry.setQuantity(new int[0]);
				} else {
					customerEntry = customersRecord[prevHistory];
				}
				do {
					continueShopping = false;
					System.out.println("The available items are :");
					showAvailableItems(itemsRecord);
					customerEntry.setItemsPurchased(
							addItemEntry(customerEntry.getItemsPurchased(), getValidatedItem(itemsRecord)));
					customerEntry
							.setQuantity(addQuantity(customerEntry.getQuantity(), getValidatedInteger("quantity")));
					System.out.println("Do you want to continue shopping?:");
					if (getValidatedInteger("choice") == 1)
						continueShopping = true;
				} while (continueShopping);
				break;
			case 2:
				System.out.println("Enter the customer's mobile number to find his bill :");
				mobileNumber = getValidatedInput("mobileNumber");
				prevHistory = getCustomerPrevRecord(customersRecord, mobileNumber);
				if (prevHistory == -1)
					System.out.println("The customer with mobile number " + mobileNumber + " has not been visited");
				else
					System.out.println("The totalBill is:" + calculateTotalBill(customersRecord[prevHistory]));
				break;
			case 3:
				Item mostSold = getMostSoldItem(itemsRecord, customersRecord);
				if (mostSold == null)
					System.out.println("Customers have not shopped anything yet");
				else
					mostSold.displayItem();
				break;
			case 4:
				Customer mostValued = getMostValuedCustomer(customersRecord);
				if (mostValued == null)
					System.out.println("Customers have not shopped anything yet");
				else
					System.out.println(mostValued.getFirstName());
				break;
			case 5:
				System.out.println("Exiting!!");
				break;
			default:
				System.out.println("Enter the right choice:");
			}

		} while (choice != 5);
	}

	private Customer getMostValuedCustomer(Customer[] customersRecord) {
		int maxTotal = -1, mostValued = -1, bill;
		for (int i = 0; i < customersRecord.length; i++) {
			bill = calculateTotalBill(customersRecord[i]);
			if (bill > maxTotal) {
				maxTotal = bill;
				mostValued = i;
			}
		}
		if (mostValued != -1)
			return customersRecord[mostValued];
		return null;
	}

	private Item getMostSoldItem(Item[] itemsRecord, Customer[] customersRecord) {

		int maxFreq = -1, maxSold = -1, freq;
		for (int i = 0; i < itemsRecord.length; i++) {
			freq = 0;
			for (int j = 0; j < customersRecord.length; j++) {
				for (int k = 0; k < customersRecord[j].getItemsPurchased().length; k++) {
					if (itemsRecord[i].getItemCode()
							.compareTo(customersRecord[j].getItemsPurchased()[k].getItemCode()) == 0)
						freq += customersRecord[j].getQuantity()[k];
					if (freq > maxFreq) {
						maxFreq = freq;
						maxSold = i;
					}
				}
			}
		}
		if (maxSold == -1)
			return null;
		return itemsRecord[maxSold];
	}

	private int calculateTotalBill(Customer customer) {

		int totalMRP = 0;
		int totalDiscount = 0;
		for (int i = 0; i < customer.getItemsPurchased().length; i++) {
			totalMRP += customer.getItemsPurchased()[i].getPriceinMRP() * customer.getQuantity()[i];
			totalDiscount += customer.getItemsPurchased()[i].getDiscount() * customer.getQuantity()[i];
		}
		// System.out.println("The totalMRP is:"+totalMRP);
		// System.out.println("The totalDiscount is:"+totalDiscount);
		return (totalMRP - totalDiscount);
	}

	private int[] addQuantity(int quantityRec[], int quantity) {
		int currLen = quantityRec.length;
		int temp[] = new int[currLen + 1];
		for (int i = 0; i < currLen; i++)
			temp[i] = quantityRec[i];
		temp[currLen] = quantity;
		return temp;
	}

	private void showAvailableItems(Item[] itemsRecord) {
		for (int i = 0; i < itemsRecord.length; i++) {
			itemsRecord[i].displayItem();
			System.out.println();
		}
	}

	private int getCustomerPrevRecord(Customer[] customersRecord, String mobileNumber) {
		int prevHist = -1;
		for (int i = 0; i < customersRecord.length; i++) {
			if (customersRecord[i].getMobileNumber().compareTo(mobileNumber) == 0) {
				prevHist = i;
				break;
			}
		}
		return prevHist;
	}

	private int createMenu() {
		int choice;
		System.out.println("Enter your choice:");
		System.out.println("1. Enter the customer details:");
		System.out.println("2. Calculate the total bill of a customer:");
		System.out.println("3. Find the most sold item");
		System.out.println("4. Find the most valued customer:");
		System.out.println("5. Exit");
		choice = getValidatedInteger("Integer");
		return choice;
	}

	private int getValidatedInteger(String validationType) {
		int number;
		boolean isValid;
		switch (validationType) {
		case "Integer":
			System.out.println("Enter an integer :");
			while (!input.hasNextInt()) {
				String userInput = input.next();
				System.out.printf("\"%s\" is not a valid number,try again.\nEnter an integer :", userInput);
			}
			number = input.nextInt();
			return number;
		case "quantity":
			do {
				isValid = true;
				System.out.println("Enter the quantity of the item");
				number = getValidatedInteger("Integer");
				if (number <= 0) {
					isValid = false;
					System.out.println("Quantity should be a natural number try again!!");
				}
			} while (!isValid);
			return number;
		case "choice":
			do {
				isValid = true;
				System.out.println("Enter your choice:");
				System.out.println("1.yes");
				System.out.println("2.no");
				number = getValidatedInteger("Integer");
				if (number < 1 || number > 2) {
					isValid = false;
					System.out.println("Wrong choice try again!!");
				}
			} while (!isValid);
			return number;
		}
		return -1;
	}

	private Customer[] addEntry(Customer customersRecord[], Customer customerEntry) {
		int currLen = customersRecord.length;
		Customer temp[] = new Customer[currLen + 1];
		for (int i = 0; i < currLen; i++)
			temp[i] = customersRecord[i];
		temp[currLen] = customerEntry;
		return temp;
	}

	private Item[] addItemEntry(Item itemsPurchased[], Item newEntry) {
		int currLen = itemsPurchased.length;
		Item temp[] = new Item[currLen + 1];
		for (int i = 0; i < currLen; i++)
			temp[i] = itemsPurchased[i];
		temp[currLen] = newEntry;
		return temp;
	}

	private Item getValidatedItem(Item itemsRecord[]) {
		int inputChoice;
		boolean isValid;
		Item choosenItem;
		do {
			isValid = true;
			System.out.println("Choose the Item code:");
			System.out.println("1.MTree101");
			System.out.println("2.MTree102");
			System.out.println("3.MTree103");
			System.out.println("4.MTree104");
			System.out.println("5.MTree105");
			inputChoice = getValidatedInteger("Integer");
			if (inputChoice == 1)
				choosenItem = itemsRecord[0];
			else if (inputChoice == 2)
				choosenItem = itemsRecord[1];
			else if (inputChoice == 3)
				choosenItem = itemsRecord[2];
			else if (inputChoice == 4)
				choosenItem = itemsRecord[3];
			else if (inputChoice == 5)
				choosenItem = itemsRecord[4];
			else {
				System.out.println("Wrong input try again");
				isValid = false;
				choosenItem = null;
			}
		} while (!isValid);
		return choosenItem;
	}

	private String getValidatedInput(String validationType) {
		String inputString;
		boolean isValid;
		switch (validationType) {
		case "mobileNumber":
			do {
				isValid = true;
				System.out.println("Enter the mobile number:");
				inputString = input.next();
				if (inputString.length() != 10) {
					System.out.println("The mobile number should be 10 digit long");
					isValid = false;
				} else {
					for (int i = 0; i < inputString.length(); i++)
						if (!(inputString.charAt(i) >= '0' && inputString.charAt(i) <= '9')) {
							isValid = false;
							System.out.println("Mobile number should be numeric,try again");
							break;

						}
				}
			} while (!isValid);
			return inputString;
		case "firstName":
			do {
				isValid = true;
				System.out.println("Enter your name in alphastring :");
				inputString = input.next();
				for (int i = 0; i < inputString.length(); i++)
					if (!((inputString.charAt(i) >= 'A' && inputString.charAt(i) <= 'Z')
							|| (inputString.charAt(i) >= 'a' && inputString.charAt(i) <= 'z'))) {
						System.out.println("You have not entered a alphastring!Try again!!");
						isValid = false;
						break;
					}
			} while (!isValid);
			return inputString;
		}
		return null;
	}
}