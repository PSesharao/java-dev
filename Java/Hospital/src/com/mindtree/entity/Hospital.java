package com.mindtree.entity;

public class Hospital {
	private String id;
	private String name;
	private String location;
	private Doctor doctorList[];
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Doctor[] getDoctorList() {
		return doctorList;
	}
	public void setDoctorList(Doctor[] doctorList) {
		this.doctorList = doctorList;
	}
	public Hospital(String id, String name, String location) {
		this.id = id;
		this.name = name;
		this.location = location;
	}
}
