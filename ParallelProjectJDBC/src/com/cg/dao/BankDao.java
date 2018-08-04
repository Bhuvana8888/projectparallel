package com.cg.dao;

import com.cg.bean.Bank;
import com.cg.exception.BankException;

public interface BankDao {

	public String createAccount(Bank acc) throws BankException;
	public double showBalance(String phoneNo) throws BankException;
	public Bank withdraw(String phoneNo,double withdrawAmt) throws BankException;
	public Bank deposit(String phoneNo,double depositAmt) throws BankException;
	public Bank printTransactionDetails(String mobileNo) throws BankException;
}
