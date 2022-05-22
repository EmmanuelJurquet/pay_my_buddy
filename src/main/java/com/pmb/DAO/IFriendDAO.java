package com.pmb.DAO;


import java.util.List;

import com.pmb.model.Friend;

public interface IFriendDAO {
	
	public List<Friend> getFriendList  (int idOwner);  
	
	public boolean addContact (int  idOwner, int idReceiver); 
	
	public boolean deleteContact (int  idOwner, int idReceiver);
	
	public boolean verify (int idOwner, int idReceiver);
}

