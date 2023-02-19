package com.sk.services;

import java.util.List;

import com.sk.dtos.UserDto;

public interface UserService {
	
	
	
	//create
	
	
	UserDto createUser(UserDto userDto);
	
	//update
	

	UserDto updateUser(UserDto userDto,String userId);	
	
	//delete
	
	
	
	void deleteUser(String userId);
	
	//get all  users
	
	
	
	List<UserDto> getAllUser();
	
	
	//get single user by id
	
	UserDto getUserById(String userId);
	
	
	//get user my email id
	
	UserDto getUserByEmail(String email);
	
	//search user
	
	
	List<UserDto> searchUser(String keyword);
	
	
	
	
	//other user specific feature
	
	

}
