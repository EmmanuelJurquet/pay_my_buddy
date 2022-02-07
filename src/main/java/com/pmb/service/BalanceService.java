package com.pmb.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.pmb.DAO.IBalanceDAO;
import com.pmb.model.Balance;

public class BalanceService {

	
	@Autowired 
	IBalanceDAO balDAO;
	
	public  Balance getBalance (String userEmail)  throws ClassNotFoundException, SQLException {
			return balDAO.getUserBalance(userEmail);
	}
	
}
