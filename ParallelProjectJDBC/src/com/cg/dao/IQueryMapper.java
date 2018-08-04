package com.cg.dao;

public interface IQueryMapper {

	public String insert="insert into bank(customerName,phoneNo,email,accountBalance) values(?,?,?,?)";
	public String getBal="select accountbalance from bank where phoneNo=?";
	public String getacc="select * from bank where phoneNo=?";
	public String update_bal_query="update bank set accountBalance=? where phoneNo=?";
}
