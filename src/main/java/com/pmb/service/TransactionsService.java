package com.pmb.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmb.DAO.ITransactionsDAO;
import com.pmb.DAO.IWalletDAO;
import com.pmb.model.Transactions;

@Service
public class TransactionsService {
	
	@Autowired
	IWalletDAO balDAO; 
	
	@Autowired
	ITransactionsDAO transacDAO;
	
	private static final Logger logger = LogManager.getLogger(WalletService.class);
	
	public List<Transactions> getTransaction (int idOwner) {
		return transacDAO.getTransaction(idOwner);
	}
	/**
	 * 
	 * @param idOwner = payeur ;
	 * @param idReceiver = payé;
	 * @param amount = montant de la somme;
	 * @return 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * 
	 */
	public boolean paymentBuddy (int idOwner, int idReceiver , double amount) throws ClassNotFoundException, SQLException {
			boolean result = false;
			Transactions tra = new Transactions();
			double wal = balDAO.getBal(idOwner);
			double wal2 = balDAO.getBal(idReceiver); 
			double amountwithfee = amount*0.05+amount;
			if (wal >=amountwithfee) {
				
				wal = wal - amountwithfee;
				wal2= wal2 +  amount;
				balDAO.payment(idOwner, wal);
				balDAO.payment(idReceiver,wal2);
				tra.setDesignation("Transfert d'argent");
				tra.setAmount(amount);
				tra.setDate(LocalDate.now());
				tra.setEmmitid(idOwner);
				tra.setReceivid(idReceiver);
				tra.setFee(amount*0.05);
				transacDAO.saveTransactions(tra);
				result=true;
				}
			else {
				logger.info("Payment Error");
			}
			
			return result;
			
		}

	}
		
	

