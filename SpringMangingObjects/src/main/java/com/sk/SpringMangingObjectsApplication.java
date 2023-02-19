package com.sk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.sk.entities.Person;

@SpringBootApplication
@ComponentScan(basePackages={"com.sk.*","test","test1"})
public class SpringMangingObjectsApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(SpringMangingObjectsApplication.class, args);
		
		Person personBean=context.getBean(Person.class);
		personBean.playwithAnimal();
		
		
		
	}

}
