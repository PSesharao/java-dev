package com.mindtree.challenge.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@SequenceGenerator(name="seq1", initialValue= 120000, allocationSize=100)
public class Laptop {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq1")
	private long serialNum;
	private String brand;
	@JsonIgnore
	@OneToOne
	private Mind mind;
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Mind getMind() {
		return mind;
	}
	public void setMind(Mind mind) {
		this.mind = mind;
	}
	public long getSerialNum() {
		return serialNum;
	}
	public void setSerialNum(long serialNum) {
		this.serialNum = serialNum;
	}
}
