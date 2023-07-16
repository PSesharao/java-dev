
package com.mindtree.passenger.entity;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity

@Table(name = "pending_table")

@SequenceGenerator(name = "pendingseq", initialValue = 321600, allocationSize = 1)
public class PendingRequest {

	@Id

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pendingseq")

	@Column(name = "pending_id")
	private long id;
	@Column(name = "passenger_name")
	private String name;
	
	private String gender;
	private String address;
	@ElementCollection
	@CollectionTable(name = "pending_hobby_table", joinColumns = @JoinColumn(name = "pending_id"))
	@Column(name = "hobby")
	private List<String> hobbyList;
	@Column(name = "passenger_fav_food")
	private String favouriteFood;
	@Column(name = "passenger_email")
	private String email;
	@Column(name = "passenger_age")
	private int age;
	@Column(name = "train_id")
	private long trainId;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFavouriteFood() {
		return favouriteFood;
	}

	public void setFavouriteFood(String favouriteFood) {
		this.favouriteFood = favouriteFood;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getTrainId() {
		return trainId;
	}

	public void setTrainId(long trainId) {
		this.trainId = trainId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
