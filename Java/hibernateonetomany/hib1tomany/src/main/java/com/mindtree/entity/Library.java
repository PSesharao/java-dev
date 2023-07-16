package com.mindtree.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Library {
	@Id
	private String libId;
	private String libName;
	@OneToMany(mappedBy="library")  // mapped by will avoid 3 rd table Lib Book
	private List<Book> books;
	
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

	public Library(String libId, String libName) {
		this.libId = libId;
		this.libName = libName;
	}

	public Library() {

	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
