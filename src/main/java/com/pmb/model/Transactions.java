package com.pmb.model;
import java.time.LocalDate;

public class Transactions {

	
	private int id;
	
	private String designation;	
	
	private double amount;
	
	private LocalDate date;
	
	private String ibanTransmitter;
	
	private String ibanReceiver;
	
	private UserProfile transmitter;
	
	private Contacts receiver;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getIbanTransmitter() {
		return ibanTransmitter;
	}

	public void setIbanTransmitter(String ibanTransmitter) {
		this.ibanTransmitter = ibanTransmitter;
	}

	public String getIbanReceiver() {
		return ibanReceiver;
	}

	public void setIbanReceiver(String ibanReceiver) {
		this.ibanReceiver = ibanReceiver;
	}

	public UserProfile getTransmitter() {
		return transmitter;
	}

	public void setTransmitter(UserProfile transmitter) {
		this.transmitter = transmitter;
	}

	public Contacts getReceiver() {
		return receiver;
	}

	public void setReceiver(Contacts receiver) {
		this.receiver = receiver;
	}

	@Override
	public String toString() {
		return "Transactions [id=" + id + ", designation=" + designation + ", amount=" + amount + ", date=" + date
				+ ", ibanTransmitter=" + ibanTransmitter + ", ibanReceiver=" + ibanReceiver + ", transmitter="
				+ transmitter + ", receiver=" + receiver + "]";
	}
	
	
	
	
	
}
