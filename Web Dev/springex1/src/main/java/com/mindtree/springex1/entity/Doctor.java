package com.mindtree.springex1.entity;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Doctor {
	@Id
	private String id;
	private String name;
	private String designation;
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
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
}
