package com.pmb.controller;

import java.sql.SQLException;

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
	
	
	@GetMapping(value="/identification")
	public Identification findbyIdentification ( @RequestParam String userEmail, @RequestParam String userPassword) throws ClassNotFoundException, SQLException {
		logger.info("Identification Connection");
		Identification  idConnect = idService.findbyIdentification( userEmail,  userPassword);
		return idConnect;
	}

	
	
	
}

