package com.generic.ur.helper;

import java.util.List;

import org.dozer.DozerBeanMapper;

import com.generic.ur.entity.User;
import com.generic.ur.entity.UserAddress;
import com.generic.ur.model.UserDTO;



public class BeanConverterHelper {
	
public static User copyUserDTOtoUserEntity(UserDTO userDTO){

	User user = new DozerBeanMapper().map(userDTO, User.class);
	
	List<UserAddress> userAddress= user.getUserAddress();
	
	userAddress.forEach(userAdd-> userAdd.setUser(user)); 
	
	user.setUserAddress(userAddress);
	
	return user;
	
	
}
public static UserDTO copyUserEntitytoUserDTO(User user){

	UserDTO userDTO = new DozerBeanMapper().map(user, UserDTO.class);
	
	return userDTO;
	
}

	
}
