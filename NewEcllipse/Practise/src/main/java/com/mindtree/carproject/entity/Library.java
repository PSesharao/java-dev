package com.mindtree.carproject.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "library_table")
@SequenceGenerator(name = "libraryseq", initialValue = 25000, allocationSize = 1)
public class Library {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "libraryseq")
	@Column(name = "library_id")
	private Long id;
	@Column(name = "library_name")
	private String name;
	@Column(name = "library_type")
	private String type;
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "library_newspaper_table", joinColumns = @JoinColumn(name = "library_id"))
	@Column(name = "newspaper")
	private List<String> newspapers;
	@JsonIgnore

	@OneToMany(mappedBy = "library", cascade = CascadeType.MERGE)
	private List<LibraryBook> bookList;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<String> getNewspapers() {
		return newspapers;
	}
	public void setNewspapers(List<String> newspapers) {
		this.newspapers = newspapers;
	}
	public List<LibraryBook> getBookList() {
		return bookList;
	}
	public void setBookList(List<LibraryBook> bookList) {
		this.bookList = bookList;
	}
}
