package com.pmb.test.integration;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.pmb.model.UserProfile;
import com.pmb.service.UserProfileService;

@SpringBootTest
@AutoConfigureMockMvc
public class UserProfileControllersTests {

	@Autowired
	MockMvc mvc;

	@MockBean
	UserProfileService usrService;

	@BeforeEach
	public void config () throws ClassNotFoundException, SQLException {

		UserProfile test = new UserProfile();
		test.setId(5);
		test.setFirstname("test");
		test.setLastname("test");
		test.setEmail("test");
		test.setBirthdate(LocalDate.now());
		test.setAddress("test");
		test.setPhone("test");
		test.setCity("test");
		test.setZip("test");

		when(usrService.saveIdsInUserProfile(test)).thenReturn(true);
		when(usrService.getIdByEmail("test")).thenReturn(5);
		when(usrService.user_Profile_Connection(5)).thenReturn(test);
	}
	@Test
	public void findUserProfile () {

		try {
			this.mvc.perform(MockMvcRequestBuilders
					.get("/user_profile?idOwner=5")
					.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


}

