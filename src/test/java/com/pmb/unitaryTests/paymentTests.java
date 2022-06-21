package com.pmb.unitaryTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pmb.model.Transactions;
import com.pmb.model.Wallet;
import com.pmb.service.TransactionsService;
import com.pmb.service.WalletService;

@SpringBootTest
public class paymentTests {
	
	
	
	@Autowired
	WalletService walServ;
	@Autowired
	TransactionsService transServ;
	
	@Test 
	public void pay () throws ClassNotFoundException, SQLException {
		
		int idOwner = 1;
		int idReceiver = 2;
		Wallet wal = new Wallet();
		Wallet wal2 = new Wallet(); 
		double amount = 150.00;
		Transactions trans = new Transactions();
		
		
		trans.setId(idOwner);
		trans.setId(idReceiver);
		trans.setAmount(amount);
		trans.setDate(LocalDate.now());
		trans.setDesignation("tests");
		trans.setFee(0.5*amount/100);
		
		
	
		assertEquals(transServ.paymentBuddy(idOwner, idReceiver, amount), wal.getBalance());
		assertEquals(transServ.paymentBuddy(idOwner, idReceiver, amount), wal2.getBalance());
	}

}
