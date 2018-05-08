package com.generic.ur.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.generic.ur.dao.UserRepository;
import com.generic.ur.entity.User;
import com.generic.ur.helper.BeanConverterHelper;
import com.generic.ur.model.UserDTO;
import com.generic.ur.model.UserLoginDTO;


@Service
public class UserRegistrationService {

	@Autowired
	private  UserRepository userData;
	
	
	
	public UserDTO getUser(String userId)
	{
		UserDTO userDTO;
		try {
		User user= userData.findByUserId(userId);
		userDTO=BeanConverterHelper.copyUserEntitytoUserDTO(user);
		}
		catch(Exception ex)
		{
			userDTO=new UserDTO();
			userDTO.setPresent(false);
		
		}
		
		return userDTO;
		
	}

	public ResponseEntity <String> createUser(UserDTO userDTO) {
		
		User updatedUser=userData.save(BeanConverterHelper.copyUserDTOtoUserEntity(userDTO));
		
		return ResponseEntity.accepted().body(updatedUser.getUserId());
	}
	
	public boolean login(String userId,String password)
	{
		boolean loginSuccess =false;
		
		UserDTO userDTO= getUser(userId);
		
		if(userDTO.isPresent()&& userDTO.getPassword().equals(password))
		{
			loginSuccess=true;
			
		}
		
		return loginSuccess;
				
	}

}
