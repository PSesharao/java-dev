package com.mindtree.passenger.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "country_table")
public class Country {
	@Id
	@Column(name = "country")
	private String name;

	@JsonIgnore
	@OneToMany(mappedBy = "country", cascade = CascadeType.MERGE)
	private List<Passenger> passengerList = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "country", cascade = CascadeType.MERGE)
	private List<City> cityList = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Passenger> getPassengerList() {
		return passengerList;
	}

	public void setPassengerList(List<Passenger> passengerList) {
		this.passengerList = passengerList;
	}

	public List<City> getCityList() {
		return cityList;
	}

	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}

	

}
