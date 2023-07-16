package assignment2.question26;

import java.util.Scanner;

public class RetailStore {
	private static Item items[] = new Item[5];
	private static Customer customers[] = new Customer[3];
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		createItems();
	

		shop();
		findMostBilledCustomer();
	}

	private static void findMostBilledCustomer() {
		int index = 0;
		int bill = customers[0].getTotalBill();
		for (int i = 1; i < 3; i++) {
			if (customers[i].getTotalBill() > bill) {
				index = i;
				bill = customers[i].getTotalBill();
			}
		}
		System.out.println("Most billed is :");
		System.out.println(customers[index]);
	}

	private static void shop() {

		for (int i = 1; i <= 3; i++) {
			System.out.println("Enter customer " + i + " details:");
			System.out.println("Enter customer " + i + " id:");
			customers[i - 1] = new Customer();
			int cid = input.nextInt();
			customers[i - 1].setId(cid);
			System.out.println("Enter no of items to be purchesed :");
			int itemCount = input.nextInt();
			customers[i - 1].setItemList(new Item[itemCount]);
			int bill = 0;
			for (int j = 0; j < itemCount; j++) {
				System.out.println("Enter item id " + j + 1 + " :");
				int itemId = input.nextInt();
				System.out.println("Enter item quality " + j + 1 + ":");
				int quantity = input.nextInt();
				Item pitem = items[itemId - 5001];
				pitem.setQuantity(quantity);
				bill += pitem.getPrice() * pitem.getQuantity();
				customers[i - 1].getItemList()[j] = pitem;
			}
			customers[i - 1].setTotalBill(bill);
		}
	}

	private static void createItems() {

		items[0] = new Item(5001, 250);
		items[1] = new Item(5002, 400);
		items[2] = new Item(5003, 300);
		items[3] = new Item(5004, 430);
		items[4] = new Item(5005, 100);
	}

}
