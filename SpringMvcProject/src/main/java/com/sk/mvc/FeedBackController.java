package com.sk.mvc;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeedBackController {

	
	
	
	//@RequestMapping(value = "/feedbacks",method = RequestMethod.GET)
	@GetMapping("/feedbacks")
	public List<String> getFeebacks(){
		
		return Arrays.asList("hello","sagar","kumar");
		
	}
}
