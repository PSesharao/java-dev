package com.mindtree.entity;

public class Patient {
	private String id;
	private Name name;
	private String symptoms[];
	private int age;
	public Patient(String id, Name name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	public String[] getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(String[] symptoms) {
		this.symptoms = symptoms;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
