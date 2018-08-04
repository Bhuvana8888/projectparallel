package com.cg.main;

import java.util.Date;
import java.util.Scanner;

import com.cg.bean.Bank;
import com.cg.exception.BankException;
import com.cg.service.BankService;
import com.cg.service.BankServiceImpl;

public class Main {

	BankService service=new BankServiceImpl();
	Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Booking App");
		Main m=new Main();
		String option="";
		while(true){
			System.out.println("1.Create Account");
			System.out.println("2.Show Balance");
			System.out.println("3.Withdraw Amount");
			System.out.println("4.Deposit Amount");
			System.out.println("5.print Transaction");
			System.out.println("6.Fund Transfer");
			System.out.println("7.Exit");
			System.out.println("Enter your choice");
			option=m.sc.nextLine();
			switch(option){
			case "1":
				m.createAccount();
				break;
			case "2":
				m.showBalance();
				break;
			case "3":
				m.withdrawAmount();
				break;
			case "4":
				m.depositAmount();
				break;
			case "5":
				m.printTransaction();		
				break;
			case "6":
				m.fundTransfer();	
				break;
			case "7":
				System.exit(0);
				break;
			default:
				System.out.println("Please select option between 1 to 7");
				break;
			}
		}
		
	}
	public void createAccount(){
		Bank acc=new Bank();
		Main m=new Main();
		System.out.println("Enter name:");
		acc.setCustomerName(sc.nextLine());
		System.out.println("Enter PhoneNo: ");
		acc.setPhoneNo(sc.nextLine());
		System.out.println("Enter email:");
		acc.setEmail(sc.nextLine());
		System.out.println("Enter AccountBalance: ");
		acc.setAccountBalance(Double.parseDouble(m.sc.nextLine()));
		
		
		try {
			String id = service.createAccount(acc);
			System.out.println(id + " has been added successfully");
		} catch (BankException e) {
			System.out.println();
			System.err.println(e.getMessage());
			System.out.println();
		}

	}
	public void showBalance(){
		System.out.println("Enter mobile number:");
		String phoneNo = sc.nextLine();

		try {
			double accountBalance = service.showBalance(phoneNo);
			System.out.println("Current balance:" + accountBalance);
		} catch (BankException e) {
			System.out.println();
			System.err.println(e.getMessage());
			System.out.println();
		}	
	}
	public void withdrawAmount(){
		System.out.println("Enter mobile number");
		String mobile = sc.nextLine();
		try {
				System.out.println("Enter amount to be withdrawn:");
				double amt = Double.parseDouble(sc.nextLine());
				Bank finalAmt = service.withdraw(mobile, amt);
				System.out.println("Account with mobile id:" + mobile+ " has been withdrawn with " + amt);
				System.out.println("Current Balance in the account:" + finalAmt);
			}catch(BankException e) {
			// TODO Auto-generated catch block
			System.out.println();
			System.err.println(e.getMessage());
			System.out.println();
		}

	}
	public void depositAmount(){
		System.out.println("Enter mobile number");
		String mobile = sc.nextLine();
		try {
				System.out.println("Enter amount to be deposited:");
				double depositAmt = Double.parseDouble(sc.nextLine());
				Bank accountBalance = service.deposit(mobile, depositAmt);
				System.out.println("Account with mobile id:" + mobile
						+ " has been deposited with " + depositAmt);
				System.out.println("Current Balance in the account:" + accountBalance);

		} catch (BankException e) {
			// TODO Auto-generated catch block
			System.out.println();
			System.err.println(e.getMessage());
			System.out.println();
		}
	}
	public void printTransaction(){
		System.out.println("Enter Mobile number");
		String mobile = sc.nextLine();
		try {
			service.printTransactionDetails(mobile);
		} catch (BankException e) {
			// TODO Auto-generated catch block
			System.out.println();
			System.err.println(e.getMessage());
			System.out.println();
		}

	}
	public void fundTransfer(){
		System.out.println("Enter your mobile no:");
		String sourceMobileNo = sc.nextLine();
		System.out.println("Enter receivers mobile number:");
		String destMobileNo = sc.nextLine();
		System.out.println("Enter Transfer Amount:");
		double amount = Double.parseDouble(sc.nextLine());
		try {
			boolean res = service.fundTransfer(sourceMobileNo, destMobileNo, amount);
			if (res)
				System.out.println("Fund Transferred");

		} catch (BankException e) {
			// TODO Auto-generated catch block
			System.out.println();
			System.err.println(e.getMessage());
			System.out.println();
		}

	}

}
