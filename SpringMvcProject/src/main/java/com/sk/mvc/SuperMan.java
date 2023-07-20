package com.sk.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SuperMan {
	
	
	
	
	Logger logger=LoggerFactory.getLogger(SuperMan.class);
	@RequestMapping("/about")
	public String aboutRequestHandler() {
		System.out.println("about request");
		logger.info("aboutRequestHandler");
		return "about";
		
		
	}

}
