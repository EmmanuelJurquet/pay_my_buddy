package com.pmb.test.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.pmb.model.Identification;
import com.pmb.service.IdentificationService;


@SpringBootTest
public class IdentificationTests {


	@MockBean
	private IdentificationService idServ;
	
	@Test
	public void findByIdentification () throws ClassNotFoundException, SQLException {
	
		Identification test = new Identification();
	
		test.setEmail("hanna@gmail.com");
		test.setPassword("mdp");
		
		when(idServ.saveIds("hanna@gmail.com", "mdp")).thenReturn(false, false);
		when(idServ.findbyIdentification("hanna@gmail.com", "mdp")).thenReturn(test);
		assertEquals(idServ.saveIds("hanna@gmail.com", "mdp"), false);
		assertEquals(idServ.findbyIdentification("hanna@gmail.com", "mdp"), test);
		
	}
	@Test
	public void findByEmail () throws ClassNotFoundException, SQLException {
		Identification test = new Identification();
		
		test.setEmail("hanna@gmail.com");
		when(idServ.identificationByEmail("hanna@gmail.com")).thenReturn(test);
		
		assertEquals(idServ.identificationByEmail("hanna@gmail.com"), test);
		
		
	}
}
	
	
	
	
		
	
	
	

