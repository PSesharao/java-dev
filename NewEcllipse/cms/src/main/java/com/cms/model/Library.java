package com.cms.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "libraryLogin")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Library {

	@Id
	private String lusername;
	private String lpassword;

	public String getLusername() {
		return lusername;
	}

	public void setLusername(String lusername) {
		this.lusername = lusername;
	}

	public String getLpassword() {
		return lpassword;
	}

	public void setLpassword(String lpassword) {
		this.lpassword = lpassword;
	}

}
