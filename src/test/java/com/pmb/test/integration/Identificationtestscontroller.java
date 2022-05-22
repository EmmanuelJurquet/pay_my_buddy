package com.pmb.test.integration;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.pmb.model.Identification;
import com.pmb.service.IdentificationService;

@SpringBootTest
@AutoConfigureMockMvc
public class Identificationtestscontroller {

	
	@Autowired
    MockMvc mvc;
	
	@MockBean
	IdentificationService idService;
	
	
	@BeforeEach
	public void config() throws ClassNotFoundException, SQLException{
		
		Identification test = new Identification();
		String email = "emmanueljurquet@gmail.com";
		String password ="nouveaumotdepasse";
		when (idService.findbyIdentification(email, password)).thenReturn(test);
		
		
		
	}
	
	@Test
	public void getId () throws ClassNotFoundException, SQLException{
	
		
		try {
            this.mvc.perform(MockMvcRequestBuilders
                    .get("/identification1")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
	}
		
	@Test 
	public void getIdByEmail() throws ClassNotFoundException, SQLException{
		
		try {
            this.mvc.perform(MockMvcRequestBuilders
                    .get("/identification2")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
	}
}
	

