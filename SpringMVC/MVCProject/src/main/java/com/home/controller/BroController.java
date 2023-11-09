package com.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BroController {
	
	
	//@ResponseBody
	@RequestMapping("/cricket")
	public String giveCricketBat() 
	{ 
		
		return "MRFCricketbat";
	}

	
	
	
}
