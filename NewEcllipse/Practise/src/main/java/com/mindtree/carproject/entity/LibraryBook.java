package com.mindtree.carproject.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mindtree.carproject.embed.LibraryBookKey;

@Entity
@Table(name = "library_book_price_table")
public class LibraryBook {
	@EmbeddedId
	private LibraryBookKey key;
	
	@JsonIgnore
	@ManyToOne
	@MapsId("libraryId")
	@JoinColumn(name = "library_id")
	private Library library;
	
	@JsonIgnore
	@ManyToOne
	@MapsId("bookId")
	@JoinColumn(name = "book_id")
	private Book book;
	
	@Column(name = "price")
	private double price;

	public LibraryBookKey getKey() {
		return key;
	}

	public void setKey(LibraryBookKey key) {
		this.key = key;
	}

	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
