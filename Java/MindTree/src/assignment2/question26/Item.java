package assignment2.question26;

class Item {

	private int id;
	private int price;
	private int quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", price=" + price + ", quantity=" + quantity + "]";
	}

	public Item(int id, int price, int quantity) {

		this.id = id;
		this.price = price;
		this.quantity = quantity;
	}
	
	public Item(int id, int price)
	{
		this.id = id;
		this.price = price;
	}
	
}
