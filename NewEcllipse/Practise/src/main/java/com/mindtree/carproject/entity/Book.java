package com.mindtree.carproject.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "book_table")
@SequenceGenerator(name = "bookseq", initialValue = 2021000, allocationSize = 1)
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookseq")
	@Column(name = "book_id")
	private long id;

	@Column(name = "book_name")
	private String name;

	@Column(name = "book_author")
	private String author;

	@Column(name = "book_language")
	private String language;
	@JsonIgnore
	@OneToMany(mappedBy = "book", cascade = CascadeType.MERGE)
	private List<LibraryBook> libraryList;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public List<LibraryBook> getLibraryList() {
		return libraryList;
	}

	public void setLibraryList(List<LibraryBook> libraryList) {
		this.libraryList = libraryList;
	}
}
