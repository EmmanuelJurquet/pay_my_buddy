package com.pmb.model;


import java.time.LocalDate;

public class Balance {
	
	private int id;
	
	private int balanceAmount;
	
	private LocalDate date;

	public int getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(int balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Balance [id=" + id + ", balanceAmount=" + balanceAmount + ", date=" + date + "]";
	}

	

	

	
	
	
}
