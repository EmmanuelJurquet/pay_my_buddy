package com.pmb.model;

public class Payment {
	
	public double sold;
	
	public Payment (double s) {
		
		this.sold=s;
	}
	public void deposit (double d) {
		this.sold+=d;
		
	}
	public void withdraw (double r) {
		this.sold-=r;
		
	}
}
