package com.pmb.test.integration;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.pmb.model.Wallet;
import com.pmb.service.WalletService;

@SpringBootTest
@AutoConfigureMockMvc
public class WalletControllersTests {
	
	@Autowired
    MockMvc mvc;
	
	@MockBean
	WalletService walService;
	
	@BeforeEach
	public void config () {
		
		Wallet test = new Wallet();
		test.setBalance(100.00);
		test.setId(5);
		test.setVisacardnumber("1234");
		test.setExpiration("0/00/00");
		test.setCryptogram(100);
		
		when(walService.getSold(5)).thenReturn(test);
		when(walService.getBal(5)).thenReturn(100.00);
		
	}
	@Test
	public void getSold () {
		try {
            this.mvc.perform(MockMvcRequestBuilders
                    .get("/wallet?walId=5")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
	}
	@Test
	public void getBal() {
		try {
            this.mvc.perform(MockMvcRequestBuilders
                    .get("/wallet?idOwner=5")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
	}
}

