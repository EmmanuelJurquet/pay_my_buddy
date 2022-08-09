package com.pmb.DAO;

import java.sql.Connection;

import org.springframework.stereotype.Repository;

import com.pmb.model.Wallet;

@Repository
public interface IWalletDAO {
	
	public Wallet getSold (int walId);
	
	public double getBal (int idOwner);
	
	public boolean payment (Connection connection, int idOwner, double amount);
	
	public boolean saveWallet (Wallet wal);
	
}