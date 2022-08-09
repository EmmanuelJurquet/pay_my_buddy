package com.pmb.controller;


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
	public double getBalance (@RequestParam int walId) {
		double bal  = walService.getBal(walId);
		logger.info("{}", walId, "balance");
		return bal;

	}
	
	@GetMapping(value="/wallet2")
	public Wallet getSold (@RequestParam int idOwner)  {
		Wallet bal  = walService.getSold(idOwner);
		logger.info("{}",idOwner, "balance");
		return bal;

	}

}

