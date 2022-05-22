package com.pmb.model;



public class Friend {
	
	private int id;
	
	private String fullName;

	public int getId() {
		return id;
	}
	public String email; 
	
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Friend [id=" + id + ", fullName=" + fullName + ", email=" + email + "]";
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}
