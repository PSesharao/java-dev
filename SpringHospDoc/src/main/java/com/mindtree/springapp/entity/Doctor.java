package com.mindtree.springapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@SequenceGenerator(name="seq1", initialValue=1000, allocationSize=100)
public class Doctor {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq1")
	private int id ; 
	private String name;
	private int salary;
	@ManyToOne
	@JsonIgnore
	private Hospital hospital;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
