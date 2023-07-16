package assignment2.question26;

import java.util.Arrays;

public class Customer {
	private int id;
	private int totalBill;
	private Item itemList[];

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(int totalBill) {
		this.totalBill = totalBill;
	}

	public Item[] getItemList() {
		return itemList;
	}

	public void setItemList(Item[] itemList) {
		this.itemList = itemList;
	}

	public Customer(int id, int totalBill, Item[] itemList) {

		this.id = id;
		this.totalBill = totalBill;
		this.itemList = itemList;
	}

	public Customer() {

	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", totalBill=" + totalBill + ", itemList=" + Arrays.toString(itemList) + "]";
	}
}
