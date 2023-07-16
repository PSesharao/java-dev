package com.mindtree.entity;

public class Library {
	private String id;
	private String name;
	Book bookList[];
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
	public Book[] getBookList() {
		return bookList;
	}
	public void setBookList(Book[] bookList) {
		this.bookList = bookList;
	}
	public Library(String id, String name) {
		this.id = id;
		this.name = name;
	}
}
