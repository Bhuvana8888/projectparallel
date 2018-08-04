package com.cg.bean;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Bank {

	private String customerName;
	private String phoneNo;
	private String email;
	private double accountBalance;
	
	
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
	
	
	@Override
	public String toString() {
		return "Bank [customerName=" + customerName + ", phoneNo=" + phoneNo
				+ ", email=" + email + ", accountBalance=" + accountBalance
				+  "]";
	}
	
	
	
}
