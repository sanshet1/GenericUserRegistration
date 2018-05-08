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
"userFirstName",
"userMiddleName",
"userLastName",
"userId",
"password",
"userAddressDTO"
})
public class UserDTO {

@NotNull
@JsonProperty("userFirstName")
private String userFirstName;
@NotNull
@JsonProperty("userMiddleName")
private String userMiddleName;

@NotNull
@JsonProperty("userLastName")
private String userLastName;

@NotNull
@JsonProperty("userId")
private String userId;
@NotNull
@Size(min=5,max=10, message="Password should be in between 5 to 10 in length")
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

public UserDTO(String userFirstName, String userMiddleName, String userLastName, String userId,
		String password,List<UserAddressDTO> userAddressDTO) {
	super();
	this.userFirstName = userFirstName;
	this.userMiddleName = userMiddleName;
	this.userLastName = userLastName;
	this.userId = userId;
	this.password = password;
	this.userAddressDTO = userAddressDTO;
	
}

public UserDTO() {
	
}

@JsonProperty("userFirstName")
public String getUserFirstName() {
return userFirstName;
}

@JsonProperty("userFirstName")
public void setUserFirstName(String userFirstName) {
this.userFirstName = userFirstName;
}

@JsonProperty("userMiddleName")
public String getUserMiddleName() {
return userMiddleName;
}

@JsonProperty("userMiddleName")
public void setUserMiddleName(String userMiddleName) {
this.userMiddleName = userMiddleName;
}

@JsonProperty("userLastName")
public String getUserLastName() {
return userLastName;
}

@JsonProperty("userLastName")
public void setUserLastName(String userLastName) {
this.userLastName = userLastName;
}

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
