package com.sk.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sk.dtos.ApiResponseMessage;
import com.sk.dtos.UserDto;
import com.sk.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	// create

	@PostMapping
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {

		UserDto userDto1 = userService.createUser(userDto);
		return new ResponseEntity<>(userDto1, HttpStatus.CREATED);

	}

	// update

	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@PathVariable("userId") String userId, @RequestBody UserDto userDto) {

		UserDto updatedUserDto = userService.updateUser(userDto, userId);
		return new ResponseEntity<>(updatedUserDto, HttpStatus.OK);

	}

	// delete

	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponseMessage> deleteUser(@PathVariable("userId") String userId) {

		
		ApiResponseMessage msg=ApiResponseMessage.
				builder().
				message("User is deleted successfully").
				success(true).
				status(HttpStatus.OK).
				build();
		
		userService.deleteUser(userId);
		return new ResponseEntity<>(msg, HttpStatus.OK);

	}

	// get all
	@GetMapping
	public ResponseEntity<List<UserDto>> getAllUsers() {

		return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);

	}

	// get single

	@GetMapping("/{userId}")

	public ResponseEntity<UserDto> getUser(@PathVariable String userId) {
		return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
	}

	// get by mail

	@GetMapping("/email/{emailId}")
	public ResponseEntity<UserDto> getUserByEmail(@PathVariable String emailId) {
		return new ResponseEntity<>(userService.getUserByEmail(emailId), HttpStatus.OK);
	}

	// Search User

	@GetMapping("/search/{keywords}")
	public ResponseEntity<List<UserDto>> searchUser(@PathVariable String keywords) {
		return new ResponseEntity<>(userService.searchUser(keywords), HttpStatus.OK);
	}

}
