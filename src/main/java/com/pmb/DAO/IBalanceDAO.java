package com.pmb.DAO;

import java.sql.SQLException;

import com.pmb.model.Balance;

public interface IBalanceDAO {
	
	public Balance getUserBalance (String userEmail)  throws ClassNotFoundException, SQLException;

}
