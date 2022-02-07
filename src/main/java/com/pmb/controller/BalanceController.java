package com.pmb.controller;


import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pmb.model.Balance;

import com.pmb.service.BalanceService;

@RestController
public class BalanceController {

	
	@Autowired
	BalanceService balService;
	private static final Logger logger = LogManager.getLogger(BalanceController.class);
	
	@GetMapping
	public Balance getBalance (@RequestParam String userEmail) throws ClassNotFoundException, SQLException {
		logger.info("{}", userEmail, "balance");
		Balance bal  = balService.getBalance(userEmail);
		return bal;
		
		
	}
	
}
