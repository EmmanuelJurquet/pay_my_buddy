package com.pmb.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmb.DAO.IFriendDAO;
import com.pmb.model.Friend;

@Service
public class FriendService  {

	
	@Autowired
	IFriendDAO contDAO;
	
	 
	
	public List<Friend> getFriendList  (int idOwner)   {
		return contDAO.getFriendList(idOwner);
	}
	public boolean addContact (int idOwner, int idReceiver) {
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
