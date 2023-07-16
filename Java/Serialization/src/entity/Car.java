package entity;

import java.io.Serializable;

public class Car implements Serializable{
	private static final long serialVersionUID = -3788030304920419466L;
	private int id;
	private String name;
	//private double price;
	private String color;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}*/

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Car(int id, String name, double price, String color) {
		this.id = id;
		this.name = name;
	//	this.price = price;
		this.color = color;
	}

	public Car()
	{
		
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", price="   + ", color=" + color + "]";
	}
}
