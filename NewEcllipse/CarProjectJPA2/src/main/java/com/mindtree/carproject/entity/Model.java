package com.mindtree.carproject.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "model_table")
public class Model {
	@Id
	
	@Column(name = "model_name")
	private String name;
	@JsonIgnore
	@ManyToOne
	@JoinColumn( name = "brand_reg_number")
	private Brand brand;
	@JsonIgnore
	@OneToMany(mappedBy = "model",cascade = CascadeType.MERGE)
	private List<ModelColor> colourList;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public List<ModelColor> getColourList() {
		return colourList;
	}
	public void setColourList(List<ModelColor> colourList) {
		this.colourList = colourList;
	}
	
}
