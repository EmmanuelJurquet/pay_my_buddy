package com.pmb.test.integration;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.pmb.DAO.IWalletDAO;
import com.pmb.DAO.TransactionsDAO;
import com.pmb.config.DataBaseConfig;
import com.pmb.model.Transactions;
import com.pmb.service.TransactionsService;

@TestPropertySource(locations="classpath:tests.properties")
@SpringBootTest
public class TransactionTests {
	
	@Autowired
	private DataBaseConfig dataBaseConfig;
	@Autowired
	private TransactionsService traServ;

	@Test
	@Order(1)
	public void getTransactions () {
		
	List<Transactions> test= 	traServ.getTransaction(1);
		
		assertNotNull(test);
		
		
	}
	@Test
	@Order(2)
	public void paymentBuddy () throws ClassNotFoundException, SQLException {
	
		
		
		int idOwner = 1;
		int idReceiver = 2;
		double amount= 2.00;
		
		
		
		
		boolean test = traServ.paymentBuddy(idOwner, idReceiver, amount);
		
		
		assertEquals(test,true);
		
	
}
}
