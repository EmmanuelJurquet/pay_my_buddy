package com.pmb.model;

import java.beans.JavaBean;
import java.util.Date;
@JavaBean
public class UserProfileModel {

	private String userFirstName;
	
	private String userLastName;
	
	private Date birhtDate;
	
	private String userEmail;
	
	private String userAddress;
	
	private String userPhone;

	private String userCity;
	
	private String userPostCode;

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public Date getBirhtDate() {
		return birhtDate;
	}

	public void setBirhtDate(Date birhtDate) {
		this.birhtDate = birhtDate;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserCity() {
		return userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	public String getUserPostCode() {
		return userPostCode;
	}

	public void setUserPostCode(String userPostCode) {
		this.userPostCode = userPostCode;
	}

	@Override
	public String toString() {
		return "UserProfileModel [userFirstName=" + userFirstName + ", userLastName=" + userLastName + ", birhtDate="
				+ birhtDate + ", userEmail=" + userEmail + ", userAddress=" + userAddress + ", userPhone=" + userPhone
				+ ", userCity=" + userCity + ", userPostCode=" + userPostCode + "]";
	}
	
}
