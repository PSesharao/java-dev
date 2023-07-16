package com.mindtree.entity;

import java.util.List;

public class University {
	private String univId;
	private String univName;
	private int noOfColg;
	private List<College> collegeList;
	public String getUnivId() {
		return univId;
	}
	public void setUnivId(String univId) {
		this.univId = univId;
	}
	public String getUnivName() {
		return univName;
	}
	public void setUnivName(String univName) {
		this.univName = univName;
	}
	public int getNoOfColg() {
		return noOfColg;
	}
	public void setNoOfColg(int noOfColg) {
		this.noOfColg = noOfColg;
	}
	public List<College> getCollegeList() {
		return collegeList;
	}
	public void setCollegeList(List<College> collegeList) {
		this.collegeList = collegeList;
	}
	public University(String univId, String univName, int noOfColg) {
		this.univId = univId;
		this.univName = univName;
		this.noOfColg = noOfColg;
	}
	@Override
	public String toString() {
		return "University [univId=" + univId + ", univName=" + univName + ", noOfColg=" + noOfColg + ", collegeList="
				+ collegeList + "]";
	}
}

