package com.mindtree.passenger.dto;

import java.util.List;


public class PassengerDto {
	private String name;
	private String gender;
	private String address;
	private List<String> hobbyList;
	private String favouriteFood;
	private String email;
	private int age;
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
	@Override
	public String toString() {
		return "PassengerDto [name=" + name + ", gender=" + gender + ", address=" + address + ", hobbyList=" + hobbyList
				+ ", favouriteFood=" + favouriteFood + ", email=" + email + ", age=" + age + ", trainId=" + trainId
				+ "]";
	}
	
}
