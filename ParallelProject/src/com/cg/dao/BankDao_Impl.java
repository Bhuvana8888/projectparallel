package com.cg.dao;

import java.util.HashMap;

import com.cg.bean.Bank;
import com.cg.database.BankDb;
import com.cg.exception.BankException;

public class BankDao_Impl implements IBankDao {

	public static HashMap<String,Bank> walletMap=BankDb.getBnkDb();  
		
	
	@Override
	public String CreateWallet(Bank bank) throws BankException {
		// TODO Auto-generated method stub
		walletMap.put(bank.getPhoneNo(),bank);
		return bank.getPhoneNo();
	}


	@Override
	public double showBalance(String phoneNo) throws BankException {
		// TODO Auto-generated method stub
		Bank b=walletMap.get(phoneNo);
		if(b==null){
			throw new BankException("Mobile number does not exist.");
		}
		return b.getAccountBalance();
	}


	@Override
	public Bank deposit(String phoneNo) throws BankException {
		// TODO Auto-generated method stub
		Bank b=walletMap.get(phoneNo);
		if(b==null){
			throw new BankException("Mobile number does not exist.");
		}
		return b;
	}


	@Override
	public Bank withdraw(String phoneNo) throws BankException {
		// TODO Auto-generated method stub
		Bank b=walletMap.get(phoneNo);
		if(b==null){
			throw new BankException("Mobile number does not exist.");
		}
		return b;
	}


	@Override
	public Bank printTransaction(String phoneNo) throws BankException {
		// TODO Auto-generated method stub
		Bank b=walletMap.get(phoneNo);
		if(b==null){
			throw new BankException("Mobile number does not exist.");
		}
		return b;
	}

}
