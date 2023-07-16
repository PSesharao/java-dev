package com.mindtree.passenger.entity;

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
@Table(name = "train_table")
@SequenceGenerator(name = "trainseq", initialValue = 1990220, allocationSize = 1)
public class Train {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trainseq")
	@Column(name = "train_id")
	private long id;

	@Column(name = "train_name")
	private String name;

	@Column(name = "train_source")
	private String source;

	@Column(name = "train_destination")
	private String destination;

	@Column(name = "date_of_journey")
	private String date;
	
	@OneToMany(mappedBy = "train",cascade = CascadeType.MERGE)
	@JsonIgnore
	private List<Passenger> passengerList;

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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<Passenger> getPassengerList() {
		return passengerList;
	}

	public void setPassengerList(List<Passenger> passengerList) {
		this.passengerList = passengerList;
	}
}
