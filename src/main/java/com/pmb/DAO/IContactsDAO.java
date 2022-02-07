package com.pmb.DAO;

import java.sql.SQLException;

import com.pmb.model.Contacts;

public interface IContactsDAO {
	
	public Contacts Conctact_onnection (String email)  throws ClassNotFoundException, SQLException;
	
	public boolean updateContacts (String  firstName, String lastName )  throws ClassNotFoundException, SQLException;
	
	public boolean addContact (Contacts contact) throws ClassNotFoundException, SQLException;
	
	public boolean deleteContact (String firstName,String lastName)throws ClassNotFoundException, SQLException;
}
