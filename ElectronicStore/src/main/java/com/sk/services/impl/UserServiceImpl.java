package com.sk.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sk.dtos.UserDto;
import com.sk.repositories.UserRepository;
import com.sk.services.UserService;



@Service
public class UserServiceImpl implements UserService{

	
	
	
	private UserRepository userRepository;
	
	
	@Override
	public UserDto createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		
		
		return null;
	}

	@Override
	public UserDto updateUser(UserDto userDto, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(String userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserDto> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto getUserById(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDto> searchUser(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
