package com.generic.ur.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserLoginDTO {
	
@NotNull
@JsonProperty("userId")
private String userId;

@NotNull
@Size(min=5,max=10, message="Password should be in between 5 to 10 in length")
@JsonProperty("password")
private String password;

@JsonProperty("userId")
public String getUserId() {
	return userId;
}

@JsonProperty("userId")
public void setUserId(String userId) {
	this.userId = userId;
}

@JsonProperty("password")
public String getPassword() {
	return password;
}

@JsonProperty("password")
public void setPassword(String password) {
	this.password = password;
}

}
