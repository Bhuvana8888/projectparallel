package com.cg.service;

import com.cg.bean.Bank;
import com.cg.exception.BankException;

public interface IBankService {

	String CreateWallet(Bank bank) throws BankException;
	double showBalance(String phoneNo)throws BankException;
	Bank deposit (String phoneNo,double depositAmount)throws BankException;
	Bank withdraw (String phoneNo,double withdrawAmount)throws BankException;
	Bank printTransaction(String phoneNo)throws BankException;
    boolean fundTransfer(String phoneNo1,String phoneNo2,double transferAmount) throws BankException;
}
