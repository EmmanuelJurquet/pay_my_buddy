package com.pmb.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmb.DAO.ITransactionsDAO;
import com.pmb.DAO.IWalletDAO;
import com.pmb.model.Transactions;
import com.pmb.model.Wallet;

@Service
public class WalletService {

	
	
	@Autowired 
	IWalletDAO walDAO;
	/**
	 * 
	 * @param walId
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private static final Logger logger = LogManager.getLogger(WalletService.class);
	
	public  Wallet getSold (int walId)  throws ClassNotFoundException, SQLException {
		logger.info(walDAO.getSold(walId));	
		return walDAO.getSold( walId);
			
	}
	
	public double getBal (int idOwner) throws ClassNotFoundException, SQLException{
		logger.info(walDAO.getBal(idOwner));
		return walDAO.getBal(idOwner);
			
		
	}
	

	
	}

