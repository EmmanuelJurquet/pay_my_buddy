package com.pmb.DAO;

import java.sql.SQLException;

import com.pmb.model.Identification;

public interface IidentificationDAO {

	public Identification findbyIdentification ( String userEmail, String userPassword) throws ClassNotFoundException, SQLException;
	
}
