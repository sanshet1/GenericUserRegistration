package com.generic.ur.model;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"firstName",
"middleName",
"lastName",
"email",
"userId",
"password",
"userAddressDTO"
})
public class UserDTO {

@NotNull
@JsonProperty("firstName")
@Size(min=3,max=25, message="First name should be in between 3 to 25 in length")
private String firstName;

@NotNull
@Size(min=1,max=25, message="Middle name should be in between 1 to 25 in length")
@JsonProperty("middleName")
private String middleName;

@NotNull
@Size(min=3,max=25, message="Middle name should be in between 3 to 25 in length")
@JsonProperty("lastName")
private String lastName;

@NotNull
@Size(min=1,max=30, message="Email should be in between 1 to 30 in length")
@JsonProperty("email")
private String email;

@NotNull
@Size(min=8,max=20, message="User name should be in between 8 to 20 in length")
@JsonProperty("userId")
private String userId;
@NotNull
@Size(min=8,max=20, message="Password should be in between 8 to 20 in length")
@JsonProperty("password")
private String password;

@JsonIgnore
private boolean isPresent= true; 	


@NotNull
@Valid
@JsonProperty("userAddressDTO")
private List<UserAddressDTO> userAddressDTO = null;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();




public UserDTO(String firstName, String middleName, String lastName,String email, String userId,String password,List<UserAddressDTO> userAddressDTO) {
	super();
	this.firstName = firstName;
	this.middleName = middleName;
	this.lastName = lastName;
	this.email=email;
	this.userId = userId;
	this.password = password;
	this.userAddressDTO = userAddressDTO;
	
}

public UserDTO() {
	
}

@JsonProperty("firstName")
public String getFirstName() {
return firstName;
}

@JsonProperty("firstName")
public void setFirstName(String firstName) {
this.firstName = firstName;
}

@JsonProperty("middleName")
public String getMiddleName() {
return middleName;
}

@JsonProperty("middleName")
public void setMiddleName(String middleName) {
this.middleName = middleName;
}

@JsonProperty("lastName")
public String getLastName() {
return lastName;
}

@JsonProperty("lastName")
public void setLastName(String lastName) {
this.lastName = lastName;
}

@JsonProperty("userId")
public String getUserId() {
return userId;
}

@JsonProperty("email")
public String getEmail() {
	return email;
}

@JsonProperty("email")
public void setEmail(String email) {
	this.email = email;
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

@JsonProperty("userAddressDTO")
public List<UserAddressDTO> getUserAddressDTO() {
return userAddressDTO;
}

@JsonProperty("userAddressDTO")
public void setUserAddressDTO(List<UserAddressDTO> userAddressDTO) {
this.userAddressDTO = userAddressDTO;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

@JsonIgnore
public boolean isPresent() {
	return isPresent;
}

@JsonIgnore
public void setPresent(boolean isPresent) {
	this.isPresent = isPresent;
}

}
