package com.cg.service;

import java.time.LocalDateTime;

import com.cg.bean.Bank;
import com.cg.dao.BankDao;
import com.cg.dao.BankDaoImpl;
import com.cg.exception.BankException;

public class BankServiceImpl implements BankService {

	BankDao dao=new BankDaoImpl();
	@Override
	public String createAccount(Bank acc) throws BankException {
		if(!acc.getCustomerName().matches("[A-Z][A-Za-z]{3,}")){
			throw new BankException("Name should Start with a capital letter followed by small letters and should contain only alphabets.");
		}
		if(!acc.getEmail().matches("[a-z0-9{4,}]+@{1}+[a-z]{2,}+\\.com")){
			throw new BankException("Enter only valid EmailID.");
		}
		if(!acc.getPhoneNo().matches("\\d{10}")){
			throw new BankException("Phone number should contain 10 digits");
		}
		if(acc.getAccountBalance()<=0){
			throw new BankException("Balance should be greater than zero");
		}
		
		return dao.createAccount(acc);
	
	}

	@Override
	public double showBalance(String phoneNo) throws BankException {
		if(!phoneNo.matches("\\d{10}")){
			throw new BankException("Phone number should contain 10 digits");
		}
		return dao.showBalance(phoneNo);
	}

	@Override
	public Bank withdraw(String phoneNo,double withdrawAmt) throws BankException {
		Bank b=dao.withdraw(phoneNo,withdrawAmt);
		if(!phoneNo.matches("\\d{10}")){
			throw new BankException("Mobile number should be 10 digits exactly.");
		}
		if(withdrawAmt<=0){
			throw new BankException("Withdraw amount should be more than '0'.");
		}
		//sb.setDate(LocalDateTime.now());
		b.setAccountBalance(b.getAccountBalance()-withdrawAmt);
		return b;
		
	}

	@Override
	public Bank deposit(String phoneNo,double depositAmt) throws BankException {
		Bank b=dao.deposit(phoneNo,depositAmt);
		if(!phoneNo.matches("\\d{10}")){
			throw new BankException("Phone number should contain 10 digits");
		}
		if(depositAmt<=0){
			throw new BankException("Deposit amount should be greater than zero");
		}
		//b.setDate(LocalDateTime.now());
		b.setAccountBalance(b.getAccountBalance()+depositAmt);
		return b;
		
	}

	@Override
	public boolean fundTransfer(String sourceMobileNo, String destMobileNo,
			double transferAmt) throws BankException {
		if(!sourceMobileNo.matches("\\d{10}")){
			throw new BankException("Phone number should contain 10 digits");
		}
		if(!destMobileNo.matches("\\d{10}")){
			throw new BankException("Phone number should contain 10 digits ");
		}
		if(transferAmt<=0){
			throw new BankException("The amount to be withdrawn should be less than balance and greater than zero");
		}
		BankService service=new BankServiceImpl();
		Bank b1=service.withdraw(sourceMobileNo, transferAmt);
		Bank b2=service.deposit(destMobileNo, transferAmt);
		return true;
		
	}
	@Override
	public Bank printTransactionDetails(String mobileNo)
	throws BankException {
	return dao.printTransactionDetails(mobileNo);

	}


}
