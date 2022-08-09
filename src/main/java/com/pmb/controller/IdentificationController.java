package com.pmb.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.pmb.model.Identification;
import com.pmb.service.IdentificationService;

@RestController
public class IdentificationController {
	
	
	@Autowired
	private IdentificationService idService;
	private static final Logger logger = LogManager.getLogger(IdentificationController.class);
	
	//get identification by email and password
	@GetMapping(value="/identification1")
	public Identification findbyIdentification ( @RequestParam String email, @RequestParam String password)  {
		logger.info("Identification Connection");
		Identification  idConnect1 = idService.findbyIdentification( email,  password);
		return idConnect1;
	}

	// get identification just by email
	@GetMapping (value="/identification2")
	public Identification identificationByEmail ( @RequestParam String email)  {
		logger.info("Identification Connection");
		Identification  idConnect2 = idService.identificationByEmail( email);
		return idConnect2;
	
	
	
	}
}

