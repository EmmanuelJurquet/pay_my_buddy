package com.pmb.test.integration;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.pmb.model.UserProfile;
import com.pmb.service.UserProfileService;

@TestPropertySource(locations="classpath:tests.properties")
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserProfileTests {


	@Autowired
	private UserProfileService usrServ;

	@Test
	@Order(1)
	public void saveUserProfile() {
		UserProfile test = new UserProfile();
		
		test.setIdentificationId(4);
		test.setFirstname("Hanna");
		test.setLastname("Jurquet");
		test.setAddress("middle of nowhere");
		test.setEmail("hanna@gmail.com");
		test.setBirthdate(LocalDate.now());
		test.setAddress("chezpapa");
		test.setPhone("none");
		test.setCity("paris");
		test.setZip("75013");

		usrServ.saveIdsInUserProfile(test);
		
		assertEquals(usrServ.saveIdsInUserProfile(test),true);
		
		
		
		
	}
	
	@Test
	@Order(2)
	public void getUserProfile () {
		

		UserProfile test = usrServ.user_Profile_Connection(4);
		
		
		assertNotNull(test);


	}

	
	
	@Test
	@Order(3)
	public void getIdByEmail () {

		String email = "hanna@gmail.com";
		
		usrServ.getIdByEmail(email);
		
		assertEquals(usrServ.getIdByEmail(email),4);
		
		
		
	

	}
}