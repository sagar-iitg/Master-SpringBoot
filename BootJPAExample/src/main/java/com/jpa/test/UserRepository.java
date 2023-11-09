package com.jpa.test;


import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;




@EnableJpaRepositories
public interface UserRepository extends CrudRepository<User, Integer> 
{  
	
	
	
}
