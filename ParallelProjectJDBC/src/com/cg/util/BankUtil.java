package com.cg.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.cg.exception.BankException;

public class BankUtil {

	public static Connection getConnection() throws BankException{
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection(url,"system","orcl11g");
		}catch(ClassNotFoundException e){
			throw new BankException(e.getMessage());
		}catch(SQLException e1){
			throw new BankException(e1.getMessage());
		}
		
	}

}
