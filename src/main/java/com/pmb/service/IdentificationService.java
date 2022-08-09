	package com.pmb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pmb.DAO.IidentificationDAO;
import com.pmb.model.Identification;

@Service
public class IdentificationService {
	
	
	@Autowired
	private IidentificationDAO idDAO;
	
	
	
	
	public Identification findbyIdentification ( String email, String password) {
			return idDAO.findbyIdentification(email, password);
	}		
	public Identification identificationByEmail (String email) {
			return idDAO.identificationByEmail(email);
	}
	public boolean saveIds (Identification ident)  {
			return idDAO.saveIdsInIdentificationTable(ident);
		}
	}
	
	
	
	


