package com.pmb.controller;


import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pmb.model.Wallet;
import com.pmb.service.WalletService;

@RestController
public class WalletController {


	@Autowired
	private	WalletService walService;
	private static final Logger logger = LogManager.getLogger(WalletController.class);

	@GetMapping(value="/wallet")
	public Wallet getBalance (@RequestParam int walId) throws ClassNotFoundException, SQLException {
		Wallet bal  = walService.getSold(walId);
		logger.info("{}", walId, "balance");
		return bal;

	}


}

