package com.mindtree.springapp.Dto;
public class PersonDto {
	private String id ;
	private String name;
	private int age ;
	private String gender ;
	private PassportDto passport ;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public PassportDto getPassport() {
		return passport;
	}
	public void setPassport(PassportDto passport) {
		this.passport = passport;
	}
}
