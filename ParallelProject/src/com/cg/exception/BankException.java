package com.cg.exception;

@SuppressWarnings("serial")
public class BankException extends Exception{

	public BankException(){
		super();
	}
	public BankException(String msg){
		super(msg);
	}
}
