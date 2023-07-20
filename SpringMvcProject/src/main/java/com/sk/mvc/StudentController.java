package com.sk.mvc;

import java.util.Map;
import java.util.Objects;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sk.mvc.model.Student;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	
	
	@PostMapping
	//seralize the data
	//json -object  ---> deserialize
	public Student createStudent(@RequestBody Student student ) {
		
		
		
//		String str=null;
//		System.out.println(str.length());
		
		System.out.println(student);
		return student;
		
		
		// we have to create logic
		
		
		
		
	}

}
