package com.pmb.test.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.pmb.model.Friend;
import com.pmb.service.FriendService;


@TestPropertySource(locations="classpath:tests.properties")
@SpringBootTest
public class FriendTests {


	@Autowired
	private FriendService frServ;
	
	@Test
	@Order(1)
	public void addFriends () {
		
		int idOwner = 3;
		String email= "emmanueljurquet@gmail.com";
		
		frServ.addContact(idOwner,email);
		
		assertEquals(frServ.addContact(idOwner,email),true);
	}
	@Test
	@Order(2)
	public void getFriendList () {
		
		List<Friend> test = frServ.getFriendList(3);
		
		assertNotNull(test);
		
	}
	@Test
	@Order(3)
	public void deleteContact () {
		
		int idReceiver = 1;
		boolean	test=frServ.deleteContact(3, idReceiver);
		
		assertEquals(test, false);
	}
	
}	

