package com.bipul.banking.profile.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ProfileController {
	
	private static final Logger log = Logger.getLogger(ProfileController.class);
	
	@Autowired
	TestHibernate testHibernate;
	
	@GetMapping("/bipul")
	public String getTest() {		
		
		log.info("\nprofile-controller: Trying to test Logging.");
		return testHibernate.getTestColumn();
		//return "Bipul";
	}

}
