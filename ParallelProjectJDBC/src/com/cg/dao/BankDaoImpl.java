package com.cg.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.cg.bean.Bank;
import com.cg.exception.BankException;
import com.cg.util.BankUtil;

public class BankDaoImpl implements BankDao {

	@Override
	public String createAccount(Bank acc) throws BankException {
		Connection con=BankUtil.getConnection();
		PreparedStatement stat;
		try{
			con.setAutoCommit(true);
			stat=con.prepareStatement(IQueryMapper.insert);
			stat.setString(1, acc.getCustomerName());
			stat.setString(2, acc.getPhoneNo());
			stat.setString(3, acc.getEmail());
			stat.setDouble(4, acc.getAccountBalance());
			int result=stat.executeUpdate();
			if(result==1){
				con.commit();
				return acc.getPhoneNo();
			}else{
				throw new BankException(" Account not created.");
			}
		}catch(SQLException e){
			throw new BankException(e.getMessage());
		}
		
	}

	@Override
	public double showBalance(String phoneNo) throws BankException {
		Connection con=BankUtil.getConnection();
		PreparedStatement stat;
		try{
			stat=con.prepareStatement(IQueryMapper.getBal);
			stat.setString(1, phoneNo);
			ResultSet rs=stat.executeQuery();
			con.commit();
			if(rs!=null){
				rs.next();
				return rs.getDouble("accountBalance");
			}else{
				throw new BankException("Phone number does not exist.");
			}
		}catch(SQLException e){
			throw new BankException(e.getMessage());
		}
		//return 0;
		
	}

	@Override
	public Bank withdraw(String phoneNo,double withdrawAmt) throws BankException{
		Connection con=BankUtil.getConnection();
		PreparedStatement stat;
		PreparedStatement stat1;
		try{
			stat=con.prepareStatement(IQueryMapper.getacc);
			stat.setString(1, phoneNo);
			ResultSet rs=stat.executeQuery();
			if(rs!=null){
				rs.next();
				Bank b=new Bank();
				double balance=rs.getDouble("accountBalance")-withdrawAmt;
				b.setCustomerName(rs.getString("customerName"));
				b.setPhoneNo(rs.getString("phoneNo"));
				b.setEmail(rs.getString("email"));
				b.setAccountBalance(balance);
				
				stat1=con.prepareStatement(IQueryMapper.update_bal_query);
				stat1.setDouble(1, b.getAccountBalance());
				stat1.setString(2, b.getPhoneNo());
				
				int rs1=stat1.executeUpdate();
				
				if(rs1==1){
					con.commit();
					return b;
				}else{
					throw new BankException("Phone number does not exist.");	
				}
				
			}else{
				throw new BankException("Phone number does not exist.");
			}
		}catch(SQLException e){
			throw new BankException(e.getMessage());
		}
		//return null;
	}

	@Override
	public Bank deposit(String phoneNo,double depositAmt) throws BankException{
		Connection con=BankUtil.getConnection();
		PreparedStatement stat;
		PreparedStatement stat1;
		try{
			stat=con.prepareStatement(IQueryMapper.getBal);
			stat.setString(1, phoneNo);
			ResultSet rs=stat.executeQuery();
	
			if(rs!=null){
				rs.next();
				Bank b=new Bank();
				double balance=rs.getDouble("accountBalance")-depositAmt;
				b.setCustomerName(rs.getString("customerName"));
				b.setPhoneNo(rs.getString("phoneNo"));
				b.setEmail(rs.getString("email"));
				b.setAccountBalance(balance);
				
				stat1=con.prepareStatement(IQueryMapper.update_bal_query);
				stat1.setDouble(1, b.getAccountBalance());
				stat1.setString(2, b.getPhoneNo());
			
				int rs1=stat1.executeUpdate();
				
				if(rs1==1){
					con.commit();
					return b;
				}else{
					throw new BankException("Phone number does not exist.");
				}
			
			}else{
				throw new BankException("Phone number does not exist.");
			}
		}catch(SQLException e){
			throw new BankException(e.getMessage());
		}
		
	}

	@Override
	public Bank printTransactionDetails(String mobileNo) throws BankException {
		Connection con=BankUtil.getConnection();
		PreparedStatement stat;
		try{
		stat=con.prepareStatement(IQueryMapper.getacc);
		stat.setString(1, mobileNo);
		ResultSet rs=stat.executeQuery();
		con.commit();
		if(rs!=null){
		rs.next();
		Bank b=new Bank();
		b.setCustomerName(rs.getString("customerName"));
		b.setPhoneNo(rs.getString("phoneNo"));
		b.setEmail(rs.getString("email"));
		b.setAccountBalance(rs.getDouble("accountBalance"));
		//b.setDate(rs.getDate("date1"));
		return b;
		}else{
			throw new BankException("Phone number does not exist.");
		}
	}catch(SQLException e){
		throw new BankException(e.getMessage());
	}

}
}
