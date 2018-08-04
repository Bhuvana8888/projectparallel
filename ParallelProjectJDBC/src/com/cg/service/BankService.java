package com.cg.service;

import com.cg.bean.Bank;
import com.cg.exception.BankException;

public interface BankService {

	public String createAccount(Bank acc) throws BankException;
	public double showBalance(String phoneNo) throws BankException;
	public Bank withdraw(String phoneNo,double withdrawAmt) throws BankException;
	public Bank deposit(String phoneNo,double depositAmt) throws BankException;
	public boolean fundTransfer(String sourceMobileNo, String destMobileNo,
			double transferAmt) throws BankException;
	public Bank printTransactionDetails(String mobileNo)
			throws BankException;
	
	
}
