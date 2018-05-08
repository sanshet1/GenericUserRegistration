package com.generic.ur.dao;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.generic.ur.entity.User;


	public interface UserRepository extends CrudRepository<User
	, Long> {
		
		 public User findByUserId(String userId);
		 
		 }

	
	

