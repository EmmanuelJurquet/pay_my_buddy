package com.pmb.model;



public class Wallet {
	
	private int id; 
	
	private  int identificationId; 
	
	public double balance;
	
	private String visacardnumber;
	
	private String expiration;
	
	private int cryptogram;
	
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	} 

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getVisacardnumber() {
		return visacardnumber;
	}

	public void setVisacardnumber(String visacardnumber) {
		this.visacardnumber = visacardnumber;
	}

	public String getExpiration() {
		return expiration;
	}

	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}

	public int getCryptogram() {
		return cryptogram;
	}

	public void setCryptogram(int cryptogram) {
		this.cryptogram = cryptogram;
	}

	@Override
	public String toString() {
		return "Wallet [balance=" + balance + ", visacardnumber=" + visacardnumber + ", expiration=" + expiration
				+ ", cryptogram=" + cryptogram + "]";
	}

	public int getIdentificationId() {
		return identificationId;
	}

	public void setIdentificationId(int identificationId) {
		this.identificationId = identificationId;
	}

}
