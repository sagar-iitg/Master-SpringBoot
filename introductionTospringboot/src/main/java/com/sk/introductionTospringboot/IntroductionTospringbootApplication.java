package com.sk.introductionTospringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//entry point annotation
@SpringBootApplication
public class IntroductionTospringbootApplication  implements CommandLineRunner {


	@Autowired
    DBService dbService;

	public static void main(String[] args) {
		SpringApplication.run(IntroductionTospringbootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println( dbService.getData());

	}
}
