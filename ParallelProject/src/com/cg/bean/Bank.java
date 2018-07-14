package com.cg.bean;

import java.time.LocalDateTime;

public class Bank {

	private String customerName;
	private String phoneNo;
	private String email;
	private double accountBalance;
	private LocalDateTime date;
	
	
	public Bank(String customerName, String phoneNo, String email,
			double accountBalance, LocalDateTime date) {
		super();
		this.customerName = customerName;
		this.phoneNo = phoneNo;
		this.email = email;
		this.accountBalance = accountBalance;
		this.date = date;
	}
	
	
	public Bank() {
		// TODO Auto-generated constructor stub
	}


	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Bank [customerName=" + customerName + ", phoneNo=" + phoneNo
				+ ", email=" + email + ", accountBalance=" + accountBalance
				+ ", date=" + date + "]";
	}
	
	
	
}
