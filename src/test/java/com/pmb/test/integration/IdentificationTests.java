package com.pmb.test.integration;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.pmb.model.Identification;
import com.pmb.service.IdentificationService;


@TestPropertySource(locations="classpath:tests.properties")
@SpringBootTest
public class IdentificationTests {


	@Autowired
	private IdentificationService idServ;
	
	
	@Test
	@Order(1)
	public void findByIdentification () {
		
		Identification test = new Identification();
		
		test.setEmail("hanna@gmail.com");
		test.setPassword("mdp");
		
		idServ.saveIds(test);
		
		Identification test2 = 	idServ.findbyIdentification("hanna@gmail.com", "mdp");
		
		assertEquals(test.getEmail(), test2.getEmail());
		
	}
	@Test
	@Order(2)
	public void findByEmail () throws ClassNotFoundException, SQLException {
		
		
		
		
		Identification test = idServ.identificationByEmail("hanna@gmail.com");
		
		assertNotNull(test);
		
	}
	
}
	
	
	
	
		
	
	
	

