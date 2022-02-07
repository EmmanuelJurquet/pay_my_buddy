package com.pmb.model;

import java.time.LocalDate;

public class UserProfile {


	private int id;
	
	private String firstname;
	
	private String lastname;
	

	private LocalDate birthdate;
	
	private String address;
	
	private String phone;
	
	private String city;
	
	private String zip;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "UserProfileModel [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", birthdate="
				+ birthdate + ", address=" + address + ", phone=" + phone + ", city=" + city + ", zip=" + zip + "]";
	}
	
	


}
