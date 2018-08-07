package com.cg.plp.dao;

//package com.cg.account.dao;

import com.cg.plp.bean.Account;
import com.cg.plp.exception.AccountException;

public interface IAccountDao {
String CreateAccount(Account acc)throws AccountException;
double showBalance(String mobileno)throws AccountException;
Account deposit(String mobileno, double depositAmt)throws AccountException;
Account withdraw(String mobileno,double withdrawAmt)throws AccountException;
Account printTransactionDetails(String mobileno) throws AccountException;

}
