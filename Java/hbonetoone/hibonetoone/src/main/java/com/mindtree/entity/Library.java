package com.mindtree.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Library {
	@Id  // @GeneratedValue -- for automatic generation of the keys only valid for int
	private String libId;
	private String libName;
	@OneToOne
	private Book book;
	public String getLibId() {
		return libId;
	}
	public void setLibId(String libId) {
		this.libId = libId;
	}
	public String getLibName() {
		return libName;
	}
	public void setLibName(String libName) {
		this.libName = libName;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Library(String libId, String libName) {
		this.libId = libId;
		this.libName = libName;
	}
	public Library()
	{
		
	}
}
