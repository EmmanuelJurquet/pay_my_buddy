package com.pmb.DAO;

import java.sql.SQLException;

import com.pmb.model.Wallet;

public interface IWalletDAO {
	
	public Wallet getSold (int idOwner)  throws ClassNotFoundException, SQLException;

	public double getBal (int idOwner) throws ClassNotFoundException, SQLException;
	
	public boolean payment (int idOwner, double amount) throws ClassNotFoundException, SQLException;
	
	
}
