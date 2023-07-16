package integratedsupermarket4;

public class Item {
	private String itemCode;
	private int priceinMRP;
	private int discount;

	public Item(String itemCode, int priceinMRP, int discount) {
		this.itemCode = itemCode;
		this.priceinMRP = priceinMRP;
		this.discount = discount;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public int getPriceinMRP() {
		return priceinMRP;
	}

	public void setPriceinMRP(int priceinMRP) {
		this.priceinMRP = priceinMRP;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public void displayItem() {
		System.out.println("itemCode   :" + this.getItemCode());
		System.out.println("priceinMRP :" + this.getPriceinMRP());
		System.out.println("discount   :" + this.getDiscount());
	}
}
