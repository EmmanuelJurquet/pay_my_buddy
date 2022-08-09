package com.pmb.model;
import java.beans.JavaBean;
import java.time.LocalDate;
@JavaBean
public class Transactions {

	
	private int id;
	
	private String designation;	
	
	private double amount;
	
	private LocalDate date;
	
	private int emmitid;
	
	private int receivid;
	
	private String receiverfullname;

	private double fee;

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

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}
	public int getEmmitid() {
		return emmitid;
	}

	public void setEmmitid(int emmitid) {
		this.emmitid = emmitid;
	}

	public int getReceivid() {
		return receivid;
	}

	public void setReceivid(int receivid) {
		this.receivid = receivid;
	}

	public String getReceiverfullname() {
		return receiverfullname;
	}

	public void setReceiverfullname(String receiverfullname) {
		this.receiverfullname = receiverfullname;
	}

	@Override
	public String toString() {
		return "Transactions [id=" + id + ", designation=" + designation + ", amount=" + amount + ", date=" + date
				+ ", emmitid=" + emmitid + ", receivid=" + receivid + ", receiverfullname=" + receiverfullname
				+ ", fee=" + fee + "]";
	}

	



	
	
	
}
