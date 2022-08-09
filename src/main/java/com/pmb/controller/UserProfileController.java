package com.pmb.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pmb.model.UserProfile;
import com.pmb.service.UserProfileService;
@RestController
public class UserProfileController {

	 
	@Autowired
	private UserProfileService userService;
	private static final Logger logger = LogManager.getLogger(UserProfileController.class);
	
		
	@GetMapping(value="/user_profile")
	public UserProfile findUserProfile ( @RequestParam int idOwner)  {
		logger.info("Profile connected:  {}", idOwner);
		UserProfile  userConnect  = userService.user_Profile_Connection( idOwner);
		return userConnect ; 	
	}
	
	
	@GetMapping(value="/get_firstname")
	public String getFirstName (@RequestParam int id) {
		String firstName = userService.getUserFirstName(id);
		return firstName;
	}

}
	
	
	

	
	

