package com.mindtree.entity;

public class Book {
	private String id;
	private String name;
	private Author authorList[];
	private int price;
	private String language;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Author[] getAuthorList() {
		return authorList;
	}
	public void setAuthorList(Author[] authorList) {
		this.authorList = authorList;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Book(String id, String name, int price, String language) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.language = language;
	}
	
}
