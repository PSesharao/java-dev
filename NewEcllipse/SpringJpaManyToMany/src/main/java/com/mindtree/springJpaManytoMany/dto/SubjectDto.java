package com.mindtree.springJpaManytoMany.dto;

public class SubjectDto {
	private String name;
	private int fullMarks;
	private float securedMarks;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getFullMarks() {
		return fullMarks;
	}
	public void setFullMarks(int fullMarks) {
		this.fullMarks = fullMarks;
	}
	public float getSecuredMarks() {
		return securedMarks;
	}
	public void setSecuredMarks(float securedMarks) {
		this.securedMarks = securedMarks;
	}
	
}
