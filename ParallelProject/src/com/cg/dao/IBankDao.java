package com.cg.dao;

import com.cg.bean.Bank;
import com.cg.exception.BankException;

public interface IBankDao {

	String CreateWallet(Bank bank) throws BankException;
	double showBalance(String phoneNo)throws BankException;
	Bank deposit (String phoneNo)throws BankException;
	Bank withdraw (String phoneNo)throws BankException;
	Bank printTransaction (String phoneNo)throws BankException;
}
