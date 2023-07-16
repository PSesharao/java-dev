package com.mindtree.jspapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserLog {
	@Id
	String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
