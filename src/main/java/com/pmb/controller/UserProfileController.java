package com.pmb.controller;

import java.sql.SQLException;

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
	public UserProfile findUserProfile ( @RequestParam String email,@RequestParam String password) throws ClassNotFoundException, SQLException {
		logger.info("Profile connected:  {}", email);
		UserProfile  userConnect  = userService.user_Profile_Connection( email, password);
		return userConnect ; 
		
		
	}
}

	
	
	

	
	

