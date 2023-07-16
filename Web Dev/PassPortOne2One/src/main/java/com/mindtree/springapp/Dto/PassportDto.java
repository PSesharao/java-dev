package com.mindtree.springapp.Dto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mindtree.springapp.entity.Person;
public class PassportDto {
	private String passNum ;
	private String issuedPlace;
	@JsonIgnore
	private Person person ;
	public String getPassNum() {
		return passNum;
	}
	public void setPassNum(String passNum) {
		this.passNum = passNum;
	}
	public String getIssuedPlace() {
		return issuedPlace;
	}
	public void setIssuedPlace(String issuedPlace) {
		this.issuedPlace = issuedPlace;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
}
