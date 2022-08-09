package com.pmb.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmb.DAO.ITransactionsDAO;
import com.pmb.DAO.IWalletDAO;
import com.pmb.config.DataBaseConfig;
import com.pmb.model.Transactions;

@Service
public class TransactionsService {

	@Autowired
	IWalletDAO balDAO; 

	@Autowired
	ITransactionsDAO transacDAO;

	@Autowired
	private DataBaseConfig dataBaseConfig;

	private static final Logger logger = LogManager.getLogger(WalletService.class);

	public List<Transactions> getTransaction (int idOwner) {
		return transacDAO.getTransaction(idOwner);
	}
	/**
	 * 
	 * @param idOwner = payeur ;
	 * @param idReceiver = payé;
	 * @param amount = montant de la somme;
	 * @return boolean =  true;
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * 
	 */
	public boolean paymentBuddy (int idOwner, int idReceiver , double amount) throws ClassNotFoundException  {

		Connection connection = null;
		boolean result = true;
		Transactions tra = null;

		double wal = balDAO.getBal(idOwner);
		double wal2 = balDAO.getBal(idReceiver); 
		double amountwithfee = (amount*0.05) + amount;

		if (wal >=amountwithfee) {

			wal = wal - amountwithfee;
			wal2= wal2 + amount;

			tra = new Transactions();
			tra.setDesignation("Transfert d'argent");
			tra.setAmount(amount);
			tra.setDate(LocalDate.now());
			tra.setEmmitid(idOwner);
			tra.setReceivid(idReceiver);
			tra.setFee(amount*0.05);

			try {

				connection = this.dataBaseConfig.getConnection();
				connection.setAutoCommit(false);

				result = balDAO.payment(connection, idOwner, wal);
				result = result && balDAO.payment(connection, idReceiver, wal2);
				result = result && transacDAO.saveTransactions(connection, tra);

			} catch (SQLException | ClassNotFoundException e) {
				logger.error(e);
			} finally {
				try {
					if(connection != null) {
						if ( !result ) {
							connection.rollback();
						} else {
							connection.commit();
						}
						connection.setAutoCommit(true);
						this.dataBaseConfig.closeConnection(connection);
					}
				}
				catch (SQLException e) {
					e.printStackTrace();
					logger.error(e);					
				}
			}
		} else {
			logger.info("Payment Error");
		}

		return result;
	}

}
		
	

