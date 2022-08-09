package com.pmb.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmb.DAO.IWalletDAO;
import com.pmb.model.Wallet;

@Service
public class WalletService {

	
	
	@Autowired 
	IWalletDAO walDAO;
	/**
	 * 
	 * @param walId
	 * @return
	 */
	private static final Logger logger = LogManager.getLogger(WalletService.class);
	
	public  Wallet getSold (int walId) {
		logger.info(walDAO.getSold(walId));	
		return walDAO.getSold( walId);
			
	}
	
	public double getBal (int idOwner) {
		logger.info(walDAO.getBal(idOwner));
		return walDAO.getBal(idOwner);
			
		
	}
	
	public boolean saveWallet (Wallet wal) {
		logger.info(walDAO.saveWallet(wal));
		return walDAO.saveWallet(wal);
	}
	
	}

