package com.generic.ur.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.generic.ur.model.UserDTO;



import com.generic.ur.service.UserRegistrationService;;
@CrossOrigin 
@RestController
public class UserRegistrationController {
	@Autowired
	private UserRegistrationService urService;
	
	@RequestMapping("/user/{userId}")
	public UserDTO getUser(@PathVariable String userId) {
		
		UserDTO userDTO= urService.getUser(userId);
						
		return userDTO;
	}

	@PostMapping("/user")
	public ResponseEntity<Map> createUser(@Valid @RequestBody UserDTO  userDTO) throws Exception {
		
		return urService.createUser(userDTO);
		
	}
	
	@RequestMapping("/login")
	public boolean login(@Valid @RequestParam("userId")  String userId,@RequestParam("password") String password) {
		
		
		return urService.login(userId,password);
			
	}
	
}