	package com.pmb.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pmb.DAO.IidentificationDAO;
import com.pmb.model.Identification;

@Service
public class IdentificationService {
	
	
	@Autowired
	private IidentificationDAO idDAO;
	
	public Identification findbyIdentification ( String email, String password) throws ClassNotFoundException, SQLException{
			return idDAO.findbyIdentification(email, password);
	}		
	public Identification identificationByEmail (String email) throws ClassNotFoundException, SQLException	{
			return idDAO.identificationByEmail(email);
	}
		
	}
	
	
	
	


