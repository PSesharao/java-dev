package com.mindtree.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Book {
	@Id
	private String bookId ; 
	private String bookName;
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Book(String bookId, String bookName) {
		this.bookId = bookId;
		this.bookName = bookName;
	}
	public Book()
	{
		
	}
}
