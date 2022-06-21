package com.pmb.DAO;



import com.pmb.model.UserProfile;

public interface IUserProfileDAO {
	
	
	public UserProfile user_Profile_Connection (int idOwner)  ;
	
	public int getIdByEmail  (String email );
	
	public boolean saveIdsInUserProfile (UserProfile usr);
	
}
