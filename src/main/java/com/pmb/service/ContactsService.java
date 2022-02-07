package com.pmb.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmb.DAO.IContactsDAO;
import com.pmb.model.Contacts;

@Service
public class ContactsService  {

	
	@Autowired
	IContactsDAO contDAO;
	
	public Contacts Conctact_connection (String email)  throws ClassNotFoundException, SQLException{
		return contDAO.Conctact_onnection(email);
	}
	
	public boolean updateContacts (String  firstName, String lastName )  throws ClassNotFoundException, SQLException{
		return contDAO.updateContacts(firstName, lastName);
	}
	
	public boolean addContact (Contacts contact) throws ClassNotFoundException, SQLException{
		return contDAO.addContact( contact);
	}
	
	public boolean deleteContact (String firstName,String lastName)throws ClassNotFoundException, SQLException{
		return contDAO.deleteContact(firstName, lastName);
	}

}
