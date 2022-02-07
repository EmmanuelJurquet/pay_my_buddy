package com.pmb.DAO;

import java.sql.SQLException;

import com.pmb.model.UserProfile;

public interface IUserProfileDAO {

	public UserProfile user_Profile_Connection (String userEmail)  throws ClassNotFoundException, SQLException;
	
	public boolean updateUserProfile (String userEmail)  throws ClassNotFoundException, SQLException;
}
