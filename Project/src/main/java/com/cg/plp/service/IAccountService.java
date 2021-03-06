package com.cg.plp.service;

import com.cg.plp.bean.Account;
import com.cg.plp.exception.AccountException;

public interface IAccountService {
	String CreateAccount(Account acc)throws AccountException;
	double showBalance(String mobileno)throws AccountException;
	Account deposit(String mobileno,double depositAmt)throws AccountException;
	Account withdraw(String mobileno,double withdrawAmt)throws AccountException;
	boolean fundTransfer(String sourcemobileno,String destmobileno,double tranferAmt)throws AccountException;
	Account printTransactionDetails(String mobileno)throws AccountException;
}
