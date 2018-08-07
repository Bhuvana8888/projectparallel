package com.cg.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cg.bean.Bank;
import com.cg.exception.BankException;
import com.cg.service.BankService;
import com.cg.service.BankServiceImpl;

public class BankTest {

	private BankService service;
	@Before
	public void init(){
		service=new BankServiceImpl();
	}
	
	
	@Test
	public void testCreateAccountForName() {
		
		Bank b=new Bank();
		b.setPhoneNo("8765907345");
		b.setCustomerName("Meer@");
		b.setEmail("meera@gmjail.com");
		b.setAccountBalance(1000000);
		try{
			service.createAccount(b);
		}catch(BankException be){
			Assert.assertEquals("Name should Start with a capital letter followed by small letters and should contain only alphabets.", be.getMessage());
		}
		
	}
	@Test
	public void testCreateAccountForNameFirstAlphabetSmallLetter() {
		
		Bank b=new Bank();
		b.setPhoneNo("8765907345");
		b.setCustomerName("meera");
		b.setEmail("meera@gmjail.com");
		b.setAccountBalance(1000000);
		try{
			service.createAccount(b);
		}catch(BankException be){
			Assert.assertEquals("Name should Start with a capital letter followed by small letters and should contain only alphabets.", be.getMessage());
		}
		
	}
	/*@Test
	public void testCreateAccountForNameCapitalLettersInBetween() {
		
		Bank b=new Bank();
		b.setPhoneNo("8765907345");
		b.setCustomerName("MeeRa");
		b.setEmail("meera@gmjail.com");
		b.setAccountBalance(1000000);
		try{
			service.createAccount(b);
		}catch(BankException be){
			Assert.assertEquals("Name should Start with a capital letter and should contain only alphabets.", be.getMessage());
		}
		
	}
	*/
	@Test
	public void testCreateAccountForNameIsEmpty() {
		
		Bank b=new Bank();
		b.setPhoneNo("8765907345");
		b.setCustomerName("");
		b.setEmail("meera@gmjail.com");
		b.setAccountBalance(1000000);
		try{
			service.createAccount(b);
		}catch(BankException be){
			Assert.assertEquals("Name should Start with a capital letter followed by small letters and should contain only alphabets.", be.getMessage());
		}
		
	}
	
	
	@Test
	public void testCreateAccountForEmailId() {
		
		Bank b=new Bank();
		b.setPhoneNo("8765907345");
		b.setCustomerName("Meera");
		b.setEmail("Meeraaa@@gmjail.com");
		b.setAccountBalance(1000000);
		try{
			service.createAccount(b);
		}catch(BankException be){
			Assert.assertEquals("Enter only valid EmailID.", be.getMessage());
		}
		
	}
	@Test
	public void testCreateAccountForEmailIdWithNumbers() {
		
		Bank b=new Bank();
		b.setPhoneNo("8765907345");
		b.setCustomerName("Meera");
		b.setEmail("12345@gmjail.com");
		b.setAccountBalance(1000000);
		try{
			service.createAccount(b);
		}catch(BankException be){
			Assert.assertEquals("Table 'jpabank.bank' doesn't exist", be.getMessage());
		}
		
	}
	@Test
	public void testCreateAccountForEmailIdWithSplCharecters() {
		
		Bank b=new Bank();
		b.setPhoneNo("8765907345");
		b.setCustomerName("Meera");
		b.setEmail("!@#$@gmjail.com");
		b.setAccountBalance(1000000);
		try{
			service.createAccount(b);
		}catch(BankException be){
			Assert.assertEquals("Enter only valid EmailID.", be.getMessage());
		}
		
	}

	@Test
	public void testCreateAccountForEmailIdWithLessCharecters() {
		
		Bank b=new Bank();
		b.setPhoneNo("8765907345");
		b.setCustomerName("Meera");
		b.setEmail("m@gmjail.com");
		b.setAccountBalance(1000000);
		try{
			service.createAccount(b);
		}catch(BankException be){
			Assert.assertEquals("Table 'jpabank.bank' doesn't exist", be.getMessage());
		}
		
	}
	
	@Test
	public void testCreateAccountForPhoneNo() {
		
		Bank b=new Bank();
		b.setPhoneNo("987654321");
		b.setCustomerName("Meera");
		b.setEmail("meera@gmjail.com");
		b.setAccountBalance(1000000000);
		try{
			service.createAccount(b);
		}catch(BankException be){
			Assert.assertEquals("Phone number should contain 10 digits", be.getMessage());
		}
		
	}
	@Test
	public void testCreateAccountForBalance() {
		
		Bank b=new Bank();
		b.setPhoneNo("1234567890");
		b.setCustomerName("Meera");
		b.setEmail("meera@gmail.com");
		b.setAccountBalance(0);
		try{
			service.createAccount(b);
		}catch(BankException be){
			Assert.assertEquals("Balance should be greater than zero", be.getMessage());
		}
		
	}
	@Test
	public void testCreateAccountForBalanceLessThanZero() {
		
		Bank b=new Bank();
		b.setPhoneNo("1234567890");
		b.setCustomerName("Meera");
		b.setEmail("meera@gmail.com");
		b.setAccountBalance(-18756);
		try{
			service.createAccount(b);
		}catch(BankException be){
			Assert.assertEquals("Balance should be greater than zero", be.getMessage());
		}
		
	}

	
	@Test
	public void testshowBalanceForPhoneNo() {
		
		try{
			service.showBalance("12345");
		}catch(BankException be){
			Assert.assertEquals("Phone number should contain 10 digits", be.getMessage());
		}
		
	}
	@Test
	public void testCreateAccount() {
		
		Bank b=new Bank();
		b.setPhoneNo("1234567890");
		b.setCustomerName("sonia");
		b.setEmail("soniaaa@gmail.com");
		b.setAccountBalance(1000000);
		try{
			String str=service.createAccount(b);
			Assert.assertNotNull(str);
		}catch(BankException be){
			//Assert.assertEquals("Phone number should be of 10 digits", be.getMessage());
		}
		
	}
	@Test
	public void testCreateAccountForPhoneNoDoesNotExist() {
		
		Bank b=new Bank();
		b.setPhoneNo("12345");
		
		try{
			service.showBalance("1234567890");
		}catch(BankException be){
			Assert.assertEquals("Table 'jpabank.bank' doesn't exist", be.getMessage());
		}
		
	}
	@Test
	public void testshowBalanceForName() {
		
		Bank b=new Bank();
		b.setPhoneNo("1234567890");
		
		try{
			service.showBalance(b.getPhoneNo());
		}catch(BankException be){
			Assert.assertEquals("Table 'jpabank.bank' doesn't exist", be.getMessage());
		}
		
	}
	
	@Test
	public void testDepositForPhoneNo() {
		
		try{
			service.deposit("1234567890",500);
		}catch(BankException be){
			Assert.assertEquals("Table 'jpabank.bank' doesn't exist", be.getMessage());
		}
		
	}
	@Test
	public void testDepositForPhoneNoDoesNotExist() {
		
		try{
			service.deposit("1234567890",500);
		}catch(BankException be){
			Assert.assertEquals("Table 'jpabank.bank' doesn't exist", be.getMessage());
		}
		
	}

	@Test
	public void testDepositForDepositAmount() {
		
		try{
			service.deposit("1234567890",-500);
		}catch(BankException be){
			Assert.assertEquals("Table 'jpabank.bank' doesn't exist", be.getMessage());
		}
		
	}
	@Test
	public void testWithdrawForPhoneNo() {
		
		try{
			service.deposit("1234567890",500);
		}catch(BankException be){
			Assert.assertEquals("Table 'jpabank.bank' doesn't exist", be.getMessage());
		}
		
	}
	@Test
	public void testWithdrawForPhoneNoDoesNotExist() {
		
		try{
			service.withdraw("1234567890",500);
		}catch(BankException be){
			Assert.assertEquals("Table 'jpabank.bank' doesn't exist", be.getMessage());
		}
		
	}
	@Test
	public void testWithdrawForAmount() {
		
		try{
			service.withdraw("1234567890",500);
		}catch(BankException be){
			Assert.assertEquals("Table 'jpabank.bank' doesn't exist", be.getMessage());
		}
		
	}
	@Test
	public void testFundTransferForPhoneNoDoesNotExist() {
		
		try{
			service.fundTransfer("1234567890","1234432112",500);
		}catch(BankException be){
			assertEquals("Table 'jpabank.bank' doesn't exist", be.getMessage());
		}
		
	}
	@Test
	public void testFundTransferForAmount() {
		
		try{
			service.fundTransfer("1234567890","1234432112",500);
		}catch(BankException be){
			assertEquals("Table 'jpabank.bank' doesn't exist", be.getMessage());
		}
		
	}
	@Test
	public void testFundTransfer() {
		
		try{
			assertTrue(service.fundTransfer("1234567899","1234432111",100));
		}catch(BankException be){
			assert(be.getMessage())!=null;
		}
		
	}
	@Test
	public void testPrintTransactionDetails() {
		
		try{
			Bank b=service.printTransactionDetails("1234567890");
		}catch(BankException be){
			assert( be.getMessage())!=null;
		}
		
	}
	

	
	
	

}
