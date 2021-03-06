package com.cg.plp.bean;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Account {
public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private String mobileNo;
private String name;
private String email;
private double balance;
LocalDateTime date;
public String getMobileNo() {
	return mobileNo;
}

public Account(int id, String mobileNo, String name, String email,
		double balance, LocalDateTime date) {
	super();
	this.id = id;
	this.mobileNo = mobileNo;
	this.name = name;
	this.email = email;
	this.balance = balance;
	this.date = date;
}
public Account() {
	// TODO Auto-generated constructor stub
}

public void setMobileNo(String mobileNo) {
	this.mobileNo = mobileNo;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public double getBalance() {
	return balance;
}
public void setBalance(double d) {
	// TODO Auto-generated method stub
	
}
}