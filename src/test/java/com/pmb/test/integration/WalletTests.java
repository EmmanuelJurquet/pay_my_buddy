package com.pmb.test.integration;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.pmb.model.Wallet;
import com.pmb.service.WalletService;

@TestPropertySource(locations="classpath:tests.properties")
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WalletTests {
	
	
	@Autowired
	private WalletService walServ;
	
	
	@Test
	@Order(1)
	public void saveWallet ()  {
		Wallet test = new Wallet ();
		
		test.setId(5);
		test.setBalance(100.00);
		test.setVisacardnumber("0000000000000000");
		test.setExpiration("1-01-01");
		test.setCryptogram(121);
		
		walServ.saveWallet(test);
		
		
		assertEquals(walServ.saveWallet(test),true);
	}		
	
	@Test
	@Order(2)
	public void getBal () {
		
		double test = walServ.getBal(5);
		
		assertEquals(test,100.00);
	
	}
	
	@Test
	@Order(2)
	public void getSold ()  {
		
		Wallet test = walServ.getSold(5);
	
		assertNotNull(test);
	}
	

}

