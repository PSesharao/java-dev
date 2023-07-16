package com.mindtree.passenger.entity;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "passenger_table")
@SequenceGenerator(name = "passengerseq", initialValue = 2021000, allocationSize = 1)
public class Passenger {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "passengerseq")
	@Column(name = "passenger_id")
	private long id;

	@Column(name = "passenger_name")
	private String name;

	@Column(name = "passenger_gender")
	private String gender;

	@Column(name = "passenger_address")
	private String address;

	@ElementCollection
	@CollectionTable(name = "passenger_hobby_table", joinColumns = @JoinColumn(name = "passenger_id"))
	@Column(name = "hobby")
	private List<String> hobbyList;

	@Column(name = "passenger_image")
	private String image;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "passenger_role_table", joinColumns = @JoinColumn(name = "passenger_id"))
	@Column(name = "role")
	private List<String> roles;

	@Column(name = "passenger_email")
	private String email;

	@Column(name = "passenger_password")
	private String password;

	@ManyToOne
	@JoinColumn( name = "country")
	private Country country;
	
	@ManyToOne
	@JoinColumn( name = "city")
	private Country city;

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<String> getHobbyList() {
		return hobbyList;
	}

	public void setHobbyList(List<String> hobbyList) {
		this.hobbyList = hobbyList;
	}

	

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
