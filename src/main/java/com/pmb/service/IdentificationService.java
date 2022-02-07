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
	
	public Identification findbyIdentification ( String userEmail, String userPassword) throws ClassNotFoundException, SQLException{
			return idDAO.findbyIdentification(userEmail, userPassword);
		
		
	}
	
	
	
	

}
