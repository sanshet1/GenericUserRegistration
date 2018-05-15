package com.generic.ur.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.generic.ur.dao.UserRepository;
import com.generic.ur.entity.User;
import com.generic.ur.helper.BeanConverterHelper;
import com.generic.ur.model.UserDTO;


@Service
public class UserRegistrationService {

	@Autowired
	private UserRepository userData;

	public UserDTO getUser(String userId) {
		UserDTO userDTO;
		try {
			User user = userData.findByUserId(userId);
			userDTO = BeanConverterHelper.copyUserEntitytoUserDTO(user);
		} catch (Exception ex) {
			userDTO = new UserDTO();
			userDTO.setPresent(false);

		}

		return userDTO;

	}

	public ResponseEntity<Map> createUser(UserDTO userDTO) throws Exception {

		String result = userDTO.getUserId() + " user is already present, choose another user name";
		UserDTO userDTOFromDB = getUser(userDTO.getUserId());

		if (!userDTOFromDB.isPresent()) {
			User updatedUser = userData.save(BeanConverterHelper.copyUserDTOtoUserEntity(userDTO));
			result = updatedUser.getUserId() + " user is created successfully!";
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", result);
		return new ResponseEntity<Map>(map, HttpStatus.CREATED);

	}

	public boolean login(String userId, String password) {
		boolean loginSuccess = false;

		UserDTO userDTO = getUser(userId);

		if (userDTO.isPresent() && userDTO.getPassword().equals(password)) {
			loginSuccess = true;

		}

		return loginSuccess;

	}

}
