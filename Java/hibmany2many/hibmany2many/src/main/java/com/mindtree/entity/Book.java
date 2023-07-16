package com.mindtree.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Book {
	@Id
	private String bookId ; 
	private String bookName;
	@ManyToMany    // It will create a separate field lib Id in Book
	private List<Library> libraries ;
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
	public List<Library> getLibraries() {
		return libraries;
	}
	public void setLibraries(List<Library> libraries) {
		this.libraries = libraries;
	}

}
