package com.pmb.controller;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pmb.model.Friend;
import com.pmb.service.FriendService;

@RestController
public class FriendController {
	
	@Autowired
	private FriendService frService ;
	private static final Logger logger = LogManager.getLogger(FriendController.class);
	
	
	@GetMapping(value="/friendlist")
	public List<Friend> getFriendList (@RequestParam int idOwner) {
		logger.info("{Friends have been found}");
		List<Friend> result = frService.getFriendList(idOwner);
		return result;
	}
	
	@PostMapping(value="/addfriend")
	public String addFriend (@RequestParam int idOwner,@RequestParam int idReceiver ) {
		logger.info("{}",  "added" );
		frService.addContact(idOwner,idReceiver);
		return "{\"success\" : true }";
	}
	@DeleteMapping(value="/removefriend")
	public void removeFriend (@RequestParam int idOwner,@RequestParam int idReceiver ) {
		logger.info("{}" , idReceiver, "has been deleted");
		frService.deleteContact(idOwner,idReceiver);
		
	}

}
	
	


