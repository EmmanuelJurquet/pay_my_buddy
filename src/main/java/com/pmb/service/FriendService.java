package com.pmb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmb.DAO.IFriendDAO;
import com.pmb.DAO.IUserProfileDAO;
import com.pmb.DAO.UserProfileDAO;
import com.pmb.model.Friend;

@Service
public class FriendService  {

	
	@Autowired
	IFriendDAO contDAO;
	@Autowired
	UserProfileDAO userDAO;
	 
	
	public List<Friend> getFriendList  (int idOwner)   {
		return contDAO.getFriendList(idOwner);
	}
	
	
	public boolean addContact (int idOwner, String email) {
		
		int idReceiver= userDAO.getIdByEmail(email);  
		if (idReceiver == -1){
			return false;
		}
		if (contDAO.verify(idOwner, idReceiver)){
		
		return true;
		}
		else 	{
			return contDAO.addContact(idOwner,idReceiver);
		}
	}
	
	public boolean deleteContact (int idOwner, int idReceiver){
		return contDAO.deleteContact(idOwner,idReceiver);
	}

}
