package com.cg.database;

import java.time.LocalDateTime;
import java.util.HashMap;

import com.cg.bean.Bank;

public class BankDb {

	private static HashMap<String,Bank> bnkDb=new HashMap<String, Bank>();
	//public static HashMap<Integer, Employee> getEmpDb;

	public static HashMap<String, Bank> getBnkDb() {
		return bnkDb;
	}
	static{
		bnkDb.put("1234432112", new Bank("Manohar", "1234432112", "manohar@gmail.com", 1000000.00,LocalDateTime.now()));
		bnkDb.put("1233211233", new Bank("Rajesh", "1233211233", "rajesh@gmail.com", 10000.00,LocalDateTime.now()));
		bnkDb.put("1221122112", new Bank("Shreshta", "1221122112", "shreshta@gmail.com", 1020000.00,LocalDateTime.now()));
		bnkDb.put("1234567890", new Bank("Sonia", "1234567890", "sonia@gmail.com", 200000.00,LocalDateTime.now()));
	}
}
