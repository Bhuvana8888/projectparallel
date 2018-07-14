package com.cg.service;

import java.time.LocalDateTime;

import com.cg.bean.Bank;
import com.cg.dao.BankDao_Impl;
import com.cg.dao.IBankDao;
import com.cg.exception.BankException;

public class BankService_Impl implements IBankService {

	IBankDao dao=new BankDao_Impl();
	@Override
	public String CreateWallet(Bank bank) throws BankException {
		// TODO Auto-generated method stub
		if(!bank.getCustomerName().matches("[A-Z][A-Za-z]{3,}")){
			throw new BankException("Name should Start with a capital letter followed by small letters and should contain only alphabets.");
		}
		if(!bank.getEmail().matches("[a-z0-9{4,}]+@{1}+[a-z]{2,}+\\.com")){
			throw new BankException("Enter only valid EmailID.");
		}
		if(!bank.getPhoneNo().matches("\\d{10}")){
			throw new BankException("Phone number should contain 10 digits");
		}
		if(bank.getAccountBalance()<=0){
			throw new BankException("Balance should be greater than zero");
		}
		
		return dao.CreateWallet(bank);
	
	}
	
	@Override
	public double showBalance(String phoneNo) throws BankException {
		// TODO Auto-generated method stub
		if(!phoneNo.matches("\\d{10}")){
			throw new BankException("Phone number should contain 10 digits");
		}
		return dao.showBalance(phoneNo);
	}	
		
	@Override
	public Bank deposit(String phoneNo,double depositAmount) throws BankException {
		
		Bank b=dao.deposit(phoneNo);
		if(!phoneNo.matches("\\d{10}")){
			throw new BankException("Phone number should contain 10 digits");
		}
		if(depositAmount<=0){
			throw new BankException("Deposit amount should be greater than zero");
		}
		b.setDate(LocalDateTime.now());
		b.setAccountBalance(b.getAccountBalance()+depositAmount);
		return b;
	}
	@Override
	public Bank withdraw(String phoneNo,double withdrawAmount) throws BankException {
	
		Bank b=dao.withdraw(phoneNo);
		if(!phoneNo.matches("\\d{10}")){
			throw new BankException("Mobile number should be 10 digits exactly.");
		}
		if(withdrawAmount<=0){
			throw new BankException("Deposit amount should be more than '0'.");
		}
		b.setDate(LocalDateTime.now());
		b.setAccountBalance(b.getAccountBalance()+withdrawAmount);
		return b;
	}
	@Override
	public Bank printTransaction(String phoneNo) throws BankException {
		// TODO Auto-generated method stub
		return dao.printTransaction(phoneNo);
	}
	@Override
	public boolean fundTransfer(String phoneNo1, String phoneNo2,
			double transferAmount) throws BankException {
	
		if(!phoneNo1.matches("\\d{10}")){
			throw new BankException("Phone number should contain 10 digits");
		}
		if(!phoneNo2.matches("\\d{10}")){
			throw new BankException("Phone number should contain 10 digits ");
		}
		IBankService service=new BankService_Impl();
		Bank b1=service.deposit(phoneNo1, transferAmount);
		Bank b2=service.deposit(phoneNo2, transferAmount);
		return false;
	}



	

	
	

}
