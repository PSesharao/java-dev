package com.mindtree.entity;

public class College {
	private String nameOfColg;
	private int noOfStud;
	public String getNameOfColg() {
		return nameOfColg;
	}
	public void setNameOfColg(String nameOfColg) {
		this.nameOfColg = nameOfColg;
	}
	public int getNoOfStud() {
		return noOfStud;
	}
	public void setNoOfStud(int noOfcolg) {
		this.noOfStud = noOfcolg;
	}
	public College(String nameOfColg, int noOfStud) {
		this.nameOfColg = nameOfColg;
		this.noOfStud = noOfStud;
	}
	@Override
	public String toString() {
		return "College [nameOfColg=" + nameOfColg + ", noOfStud=" + noOfStud + "]";
	}
}
