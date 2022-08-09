package com.pmb.DAO;

import com.pmb.model.Identification;

public interface IidentificationDAO {

	public Identification findbyIdentification ( String email, String password); 
	
	public Identification identificationByEmail ( String email);
	
	public boolean saveIdsInIdentificationTable (Identification ident);
}
