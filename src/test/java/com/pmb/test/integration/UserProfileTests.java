package com.pmb.test.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.pmb.model.UserProfile;
import com.pmb.service.UserProfileService;

@SpringBootTest
public class UserProfileTests {

	
	@MockBean
	private UserProfileService usrServ;
	
	@Test
	public void getUserProfile () throws ClassNotFoundException, SQLException {
		UserProfile test = new UserProfile();
		test.setId(5);
		test.setFirstname("Hanna");
		test.setLastname("Jurquet");
		test.setEmail("hanna@gmail.com");
		test.setBirthdate(LocalDate.now());
		test.setAddress("chezpapa");
		test.setPhone("none");
		test.setCity("paris");
		test.setZip("75013");
		
		when(usrServ.saveIdsInUserProfile(test)).thenReturn(false);
		when(usrServ.user_Profile_Connection(5)).thenReturn(test);
		assertEquals(usrServ.saveIdsInUserProfile(test), false);
		assertEquals(usrServ.user_Profile_Connection(5), test);
	}
	
	@Test
	public void saveUserProfile () {
		
		UserProfile test = new UserProfile();
		test.setId(5);
		test.setFirstname("Hanna");
		test.setLastname("Jurquet");
		test.setEmail("hanna@gmail.com");
		test.setBirthdate(LocalDate.now());
		test.setAddress("chezpapa");
		test.setPhone("none");
		test.setCity("paris");
		test.setZip("75013");
		
		when(usrServ.saveIdsInUserProfile(test)).thenReturn(false);
		assertEquals(usrServ.saveIdsInUserProfile(test), false);
		
	}
	@Test
	public void getIdByEmail () {
		
		String email = "hanna@gmail.com";
		
		when(usrServ.getIdByEmail(email)).thenReturn(5);
		assertEquals(usrServ.getIdByEmail(email),5);

	}
}