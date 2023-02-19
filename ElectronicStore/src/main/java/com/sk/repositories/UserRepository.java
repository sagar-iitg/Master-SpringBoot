package com.sk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sk.entities.User;

public interface UserRepository extends JpaRepository<User, String>
{
	
	
	

}
	