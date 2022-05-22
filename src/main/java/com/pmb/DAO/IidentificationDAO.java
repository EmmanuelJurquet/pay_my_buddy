package com.pmb.DAO;

import java.sql.SQLException;


import com.pmb.model.Identification;

public interface IidentificationDAO {

	public Identification findbyIdentification ( String email, String password) throws ClassNotFoundException, SQLException;
	
	public Identification identificationByEmail ( String email) throws ClassNotFoundException, SQLException;
}
