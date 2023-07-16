package com.mindtree.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Flight {
	@Id
	private String id;
	private String name ;
	private String source;
	private String destination;
	@OneToMany(mappedBy = "flight")
	private List<Passenger> passengerList;
	public Flight(String id, String name, String source, String destination) {
		this.id = id;
		this.name = name;
		this.source = source;
		this.destination = destination;
	}
	public Flight()
	{
		
	}
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
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public List<Passenger> getPassengerList() {
		return passengerList;
	}
	public void setPassengerList(List<Passenger> passengerList) {
		this.passengerList = passengerList;
	}
}
