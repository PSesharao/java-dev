package com.cms.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "adminLogin")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Admin {

	@Id
	private String ausername;
	private String apassword;

	public String getAusername() {
		return ausername;
	}

	public void setAusername(String ausername) {
		this.ausername = ausername;
	}

	public String getApassword() {
		return apassword;
	}

	public void setApassword(String apassword) {
		this.apassword = apassword;
	}


	public Admin(String ausername, String apassword) {
		super();
		this.ausername = ausername;
		this.apassword = apassword;
	}


	public Admin() {
		
	}


}
