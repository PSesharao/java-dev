package com.mindtree.carproject.dto;

import java.util.List;

public class LibraryDto {
	private String name;
	private String type;
	private List<String> newspapers;
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
}
