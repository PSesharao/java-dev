package com.cms.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "studentLogin")
@AllArgsConstructor
@Data
@NoArgsConstructor

public class Student {

	@Id
	private String susername;
	private String spassword;
	private String name;
	private String contact_no;;
	private String stream;
	private String batch;
	private String parent_details;

	public String getSusername() {
		return susername;
	}

	public void setSusername(String susername) {
		this.susername = susername;
	}

	public String getSpassword() {
		return spassword;
	}

	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact_no() {
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getParent_details() {
		return parent_details;
	}


	public void setParent_details(String parent_details) {
		this.parent_details = parent_details;
	}
	public Student(String susername, String spassword, String name, String contact_no, String stream, String batch,
			String parent_details) {
		super();
		this.susername = susername;
		this.spassword = spassword;
		this.name = name;
		this.contact_no = contact_no;
		this.stream = stream;
		this.batch = batch;
		this.parent_details = parent_details;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
}
