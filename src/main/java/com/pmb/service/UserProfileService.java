package com.pmb.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmb.DAO.IUserProfileDAO;
import com.pmb.model.UserProfile;

@Service
public class UserProfileService {

	@Autowired
	IUserProfileDAO userDAO;
	
	public UserProfile user_Profile_Connection (String userEmail)  throws ClassNotFoundException, SQLException{
			return userDAO.user_Profile_Connection(userEmail);
	}
	
	public boolean updateUserProfile (String userEmail)  throws ClassNotFoundException, SQLException{
			return userDAO.updateUserProfile(userEmail);
		
	}
	
	
}
