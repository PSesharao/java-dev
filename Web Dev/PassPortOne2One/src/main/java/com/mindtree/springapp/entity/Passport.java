package com.mindtree.springapp.entity;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Passport {
	@Id
	private String passNum ;
	private String issuedPlace;
	@OneToOne
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
