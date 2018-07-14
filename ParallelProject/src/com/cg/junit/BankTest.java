package com.cg.junit;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cg.bean.Bank;
import com.cg.exception.BankException;
import com.cg.service.BankService_Impl;
import com.cg.service.IBankService;

public class BankTest {

	private IBankService service;
	@Before
	public void init(){
		service=new BankService_Impl();
	}
	
	
	@Test
	public void testCreateWalletForName() {
		
		Bank b=new Bank();
		b.setPhoneNo("8765907345");
		b.setCustomerName("Meer@");
		b.setEmail("meera@gmjail.com");
		b.setAccountBalance(1000000);
		try{
			service.CreateWallet(b);
		}catch(BankException be){
			Assert.assertEquals("Name should Start with a capital letter followed by small letters and should contain only alphabets.", be.getMessage());
		}
		
	}
	@Test
	public void testCreateWalletForNameFirstAlphabetSmallLetter() {
		
		Bank b=new Bank();
		b.setPhoneNo("8765907345");
		b.setCustomerName("meera");
		b.setEmail("meera@gmjail.com");
		b.setAccountBalance(1000000);
		try{
			service.CreateWallet(b);
		}catch(BankException be){
			Assert.assertEquals("Name should Start with a capital letter followed by small letters and should contain only alphabets.", be.getMessage());
		}
		
	}
	@Test
	public void testCreateWalletForNameCapitalLettersInBetween() {
		
		Bank b=new Bank();
		b.setPhoneNo("8765907345");
		b.setCustomerName("MeeRa");
		b.setEmail("meera@gmjail.com");
		b.setAccountBalance(1000000);
		try{
			service.CreateWallet(b);
		}catch(BankException be){
			Assert.assertEquals("Name should Start with a capital letter and should contain only alphabets.", be.getMessage());
		}
		
	}
	
	@Test
	public void testCreateWalletForNameIsEmpty() {
		
		Bank b=new Bank();
		b.setPhoneNo("8765907345");
		b.setCustomerName("");
		b.setEmail("meera@gmjail.com");
		b.setAccountBalance(1000000);
		try{
			service.CreateWallet(b);
		}catch(BankException be){
			Assert.assertEquals("Name should Start with a capital letter followed by small letters and should contain only alphabets.", be.getMessage());
		}
		
	}
	
	
	@Test
	public void testCreateWalletForEmailId() {
		
		Bank b=new Bank();
		b.setPhoneNo("8765907345");
		b.setCustomerName("Meera");
		b.setEmail("Meeraaa@@gmjail.com");
		b.setAccountBalance(1000000);
		try{
			service.CreateWallet(b);
		}catch(BankException be){
			Assert.assertEquals("Enter only valid EmailID.", be.getMessage());
		}
		
	}
	@Test
	public void testCreateWalletForEmailIdWithNumbers() {
		
		Bank b=new Bank();
		b.setPhoneNo("8765907345");
		b.setCustomerName("Meera");
		b.setEmail("12345@gmjail.com");
		b.setAccountBalance(1000000);
		try{
			service.CreateWallet(b);
		}catch(BankException be){
			Assert.assertEquals("Enter only valid EmailID.", be.getMessage());
		}
		
	}
	@Test
	public void testCreateWalletForEmailIdWithSplCharecters() {
		
		Bank b=new Bank();
		b.setPhoneNo("8765907345");
		b.setCustomerName("Meera");
		b.setEmail("!@#$@gmjail.com");
		b.setAccountBalance(1000000);
		try{
			service.CreateWallet(b);
		}catch(BankException be){
			Assert.assertEquals("Enter only valid EmailID.", be.getMessage());
		}
		
	}

	@Test
	public void testCreateWalletForEmailIdWithLessCharecters() {
		
		Bank b=new Bank();
		b.setPhoneNo("8765907345");
		b.setCustomerName("Meera");
		b.setEmail("m@gmjail.com");
		b.setAccountBalance(1000000);
		try{
			service.CreateWallet(b);
		}catch(BankException be){
			Assert.assertEquals("Enter only valid EmailID.", be.getMessage());
		}
		
	}
	
	@Test
	public void testCreateWalletForPhoneNo() {
		
		Bank b=new Bank();
		b.setPhoneNo("987654321");
		b.setCustomerName("Meera");
		b.setEmail("meera@gmjail.com");
		b.setAccountBalance(1000000000);
		try{
			service.CreateWallet(b);
		}catch(BankException be){
			Assert.assertEquals("Phone number should contain 10 digits", be.getMessage());
		}
		
	}
	@Test
	public void testCreateWalletForBalance() {
		
		Bank b=new Bank();
		b.setPhoneNo("1234567890");
		b.setCustomerName("Meera");
		b.setEmail("meera@gmail.com");
		b.setAccountBalance(0);
		try{
			service.CreateWallet(b);
		}catch(BankException be){
			Assert.assertEquals("Balance should be greater than zero", be.getMessage());
		}
		
	}
	@Test
	public void testCreateWalletForBalanceLessThanZero() {
		
		Bank b=new Bank();
		b.setPhoneNo("1234567890");
		b.setCustomerName("Meera");
		b.setEmail("meera@gmail.com");
		b.setAccountBalance(-18756);
		try{
			service.CreateWallet(b);
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
	public void testCreateWallet() {
		
		Bank b=new Bank();
		b.setPhoneNo("1234567890");
		b.setCustomerName("sonia");
		b.setEmail("soniaaa@gmail.com");
		b.setAccountBalance(1000000);
		try{
			String str=service.CreateWallet(b);
			Assert.assertNotNull(str);
		}catch(BankException be){
			//Assert.assertEquals("Phone number should be of 10 digits", be.getMessage());
		}
		
	}
	@Test
	public void testCreateWalletForPhoneNoDoesNotExist() {
		
		Bank b=new Bank();
		b.setPhoneNo("12345");
		
		try{
			service.showBalance("1234567890");
		}catch(BankException be){
			Assert.assertEquals("Phone number doesnot exist", be.getMessage());
		}
		
	}
	@Test
	public void testshowBalanceForName() {
		
		Bank b=new Bank();
		b.setPhoneNo("1234567890");
		
		try{
			service.showBalance(b.getPhoneNo());
		}catch(BankException be){
			Assert.assertEquals("Phone number doesnot Exist", be.getMessage());
		}
		
	}
	@Test
	public void testDeposit() {
		
		try{
			service.deposit("1234567890",500);
		}catch(BankException be){
			Assert.assertEquals("Phone number doesnot Exist", be.getMessage());
		}
		
	}
	@Test
	public void testDepositForPhoneNo() {
		
		try{
			service.deposit("1234567890",500);
		}catch(BankException be){
			Assert.assertEquals("Phone number doesnot Exist", be.getMessage());
		}
		
	}
	@Test
	public void testDepositForPhoneNoDoesNotExist() {
		
		try{
			service.deposit("1234567890",500);
		}catch(BankException be){
			Assert.assertEquals("Phone number doesnot Exist", be.getMessage());
		}
		
	}

	@Test
	public void testDepositForDepositAmount() {
		
		try{
			service.deposit("1234567890",-500);
		}catch(BankException be){
			Assert.assertEquals("Deposit amount should be greater than zero", be.getMessage());
		}
		
	}
	@Test
	public void testWithdrawForPhoneNo() {
		
		try{
			service.deposit("1234567890",500);
		}catch(BankException be){
			Assert.assertEquals("Phone number should be greater than 10 digits", be.getMessage());
		}
		
	}
	@Test
	public void testWithdrawForPhoneNoDoesNotExist() {
		
		try{
			service.withdraw("1234567890",500);
		}catch(BankException be){
			Assert.assertEquals("Phone number doesnot Exist", be.getMessage());
		}
		
	}
	@Test
	public void testWithdrawForAmount() {
		
		try{
			service.withdraw("1234567890",500);
		}catch(BankException be){
			Assert.assertEquals("The amount to be withdrawn should be less than balance and greater than zero", be.getMessage());
		}
		
	}
	@Test
	public void testFundTransferForPhoneNo() {
		
		try{
			service.fundTransfer("1234567","1234432",500);
		}catch(BankException be){
			assertEquals("Phone number should contain 10 digits", be.getMessage());
		}
		
	}
	@Test
	public void testFundTransferForPhoneNoDoesNotExist() {
		
		try{
			service.fundTransfer("1234567890","1234432112",500);
		}catch(BankException be){
			assertEquals("Phone number doesnot Exist", be.getMessage());
		}
		
	}
	@Test
	public void testFundTransferForAmount() {
		
		try{
			service.fundTransfer("1234567890","1234432112",500);
		}catch(BankException be){
			assertEquals("The amount to be withdrawn should be less than balance and greater than zero", be.getMessage());
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
			Bank b=service.printTransaction("1234567890");
		}catch(BankException be){
			assert( be.getMessage())!=null;
		}
		
	}
	

	
	
	
	
}
