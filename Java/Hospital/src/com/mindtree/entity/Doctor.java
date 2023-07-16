package com.mindtree.entity;

public class Doctor {
	private String id;
	private Name name;
	private String specialization;
	private Patient patientList[];
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
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public Patient[] getPatientList() {
		return patientList;
	}
	public void setPatientList(Patient[] patientList) {
		this.patientList = patientList;
	}
	public Doctor(String id, Name name, String specialization) {
		this.id = id;
		this.name = name;
		this.specialization = specialization;
	}
}
