package com.sk.services.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.dtos.UserDto;
import com.sk.entities.User;
import com.sk.repositories.UserRepository;
import com.sk.services.UserService;


@Service
public class UserServiceImpl implements UserService{

	
	

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	
	
	@Override
	public UserDto createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		
		
		
		String userId=UUID.randomUUID().toString();
		
		userDto.setUserId(userId);
		
		//dto ->entity
		
		User user=dtoToEntity(userDto);
		User savedUser=userRepository.save(user);
		
		
		//
		UserDto newDto=entityToDto(savedUser);
		return newDto;
		
		
	}


	@Override
	public UserDto updateUser(UserDto userDto, String userId) {
		// TODO Auto-generated method stub
		
		User user=userRepository.findById(userId).orElseThrow(()->new RuntimeException("User not found"));
		
	
		user.setName(userDto.getName());
		user.setAbout(userDto.getAbout());
		user.setGender(userDto.getGender());
		user.setImageName(userDto.getImageName());
		user.setPassword(userDto.getPassword());
		
		
		 User updatedUser=userRepository.save(user);
		 UserDto updatedDto=entityToDto(updatedUser);
		 
		
	
		return updatedDto;
	}
	
	
	

	@Override
	public void deleteUser(String userId) {
		// TODO Auto-generated method stub
		

		User userById=userRepository.
				findById(userId).orElseThrow(()->new RuntimeException("User not found"));
		
		//delete
		userRepository.delete(userById);
		
	}

	@Override
	public List<UserDto> getAllUser() {
		// TODO Auto-generated method stub
		
		
		List<User> users=userRepository.findAll();
		
		//convert List of User to List of Dto
		List<UserDto> dtoList=users.stream().map(user->entityToDto(user)).collect(Collectors.toList());
	
		return dtoList;
		
		
	}

	@Override
	public UserDto getUserById(String userId) {
		// TODO Auto-generated method stub
		
		
		
		User user=userRepository.findById(userId).orElseThrow(()-> new RuntimeException("user not found"));
		
		
		return entityToDto(user);
		
	}

	@Override
	public UserDto getUserByEmail(String email) {
		// TODO Auto-generated method stub
		
		User user=userRepository.findByEmail(email).orElseThrow(()->new RuntimeException("user not found with given email id"));
		
		
		
		
		
		return entityToDto(user);
	}

	@Override
	public List<UserDto> searchUser(String keyword) {
		// TODO Auto-generated method stub
		
		List<User> users=userRepository.findByNameContaining(keyword);
		//convert List of User to List of Dto
		List<UserDto> dtoList=users.stream().map(user->entityToDto(user)).collect(Collectors.toList());
			
				return dtoList;
		
	
	}
	
	
	
	private UserDto entityToDto(User savedUser) {
		
		
		return mapper.map(savedUser,UserDto.class);
		
		
	}
	
	
	private User dtoToEntity(UserDto userDto)
	{
		
		return mapper.map(userDto,User.class);
		
	}
	
	
}


	
	
	
		

