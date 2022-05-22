package com.pmb.controller;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pmb.model.Transactions;
import com.pmb.service.TransactionsService;

@RestController
public class TransactionsController {
	
	
	@Autowired
	private TransactionsService transacs;
	private static final Logger logger = LogManager.getLogger(TransactionsController.class);
	
	/**
	 * 
	 * @param idOwner
	 * @return transaction history of a user.
	 */
	@GetMapping(value="/transactions1")
	public List<Transactions> getTransaction (@RequestParam int idOwner) {
	List<Transactions> result   = transacs.getTransaction(idOwner);
		logger.info("Transaction  {}", result );
		return transacs.getTransaction(idOwner);
	}
	/**
	 * 
	 * @param idOwner
	 * @param idReceiver
	 * @param amount
	 * @return boolean true =  execute payment between 2 users.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@PostMapping(value="/payment")
	public boolean payment (@RequestParam int idOwner ,@RequestParam int idReceiver, @RequestParam double amount)throws ClassNotFoundException, SQLException {
		
		logger.info( "{}", idOwner ,"has paid  :" ,idReceiver, amount );
		return transacs.paymentBuddy(idOwner, idReceiver, amount);
}
}
