package com.pmb.controller;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pmb.model.Contacts;
 
import com.pmb.service.ContactsService;

@RestController
public class ContactsController {
	
	@Autowired
	private ContactsService contService ;
	private static final Logger logger = LogManager.getLogger(ContactsController.class);
	
	
	@GetMapping(value="/contacts")
	public Contacts findContact ( @RequestParam String email) throws ClassNotFoundException, SQLException {
		logger.info("Contact founded:  {}", email);
		Contacts cont  = contService.Conctact_connection( email);
		return cont ;
	}

	@PutMapping(value ="/contacts")
	public void updateContacts ( @RequestParam String firstName, @RequestParam String lastName) throws ClassNotFoundException, SQLException{
		logger.info("Contact updated:  {}", firstName, lastName);
		contService.updateContacts(firstName, lastName);
		
	}
	@PostMapping(value="/contacts")
	public void addContact (@RequestBody Contacts contact )throws ClassNotFoundException, SQLException {
		logger.info("{}", contact, "added" );
		contService.addContact(contact);
	}
	@DeleteMapping(value="/contacts")
	public void removeContact (@RequestParam String firstName, @RequestParam String lastName)throws ClassNotFoundException, SQLException {
		logger.info("{}" , firstName, lastName, "has been deleted");
		contService.deleteContact(firstName, lastName);
		
	}
	
		
		
	}
	
	


