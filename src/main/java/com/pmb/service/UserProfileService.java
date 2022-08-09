package com.pmb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.pmb.DAO.UserProfileDAO;
import com.pmb.model.UserProfile; 

@Service
public class UserProfileService {

	@Autowired
	UserProfileDAO userDAO;
	
	
	public UserProfile user_Profile_Connection (int idOwner) {
			return userDAO.user_Profile_Connection(idOwner);
	}
	public String getUserFirstName ( int id) {
			return userDAO.getUserFirstName(id);
	}
	public boolean saveIdsInUserProfile (UserProfile usr) {
			return userDAO.saveIdsInUserProfile(usr);
	}
	public int getIdByEmail(String email) {
			return userDAO.getIdByEmail(email);
	}
}
