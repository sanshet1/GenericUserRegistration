
package com.generic.ur.model;

import java.util.HashMap;
import java.util.Map;

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
"type",
"address1",
"address2",
"street",
"city",
"pinCode"
})
public class UserAddressDTO {

@NotNull
@Size(min=1,max=1, message=" Type should be only 1 character")
@JsonProperty("type")
private String type;

@NotNull
@Size(min=3,max=30, message="Address Line 1 should be between 3 to 30 character")
@JsonProperty("address1")
private String address1;



@JsonProperty("address2")
private String address2;

@NotNull
@Size(min=3,max=30, message="Street should be between 3 to 30 character")
@JsonProperty("street")
private String street;


@NotNull
@Size(min=3,max=30, message="City name should be between 3 to 30 character")
@JsonProperty("city")
private String city;

@NotNull
@Size(min=6,max=6, message="PinCode should be 6 digit")
@JsonProperty("pinCode")
private String pinCode;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public UserAddressDTO()
{
	
}




public UserAddressDTO( String type, String address1,String address2,String street,String city,String pinCode) {
	super();
	this.type = type;
	this.address1 = address1;
	this.address2 = address2;
	this.street = street;
	this.city = city;
	this.pinCode = pinCode;
	}




@JsonProperty("type")
public String getType() {
return type;
}

@JsonProperty("type")
public void setType(String type) {
this.type = type;
}

@JsonProperty("address1")
public String getAddress1() {
return address1;
}

@JsonProperty("address1")
public void setAddress1(String address1) {
this.address1 = address1;
}

@JsonProperty("address2")
public String getAddress2() {
return address2;
}

@JsonProperty("address2")
public void setAddress2(String address2) {
this.address2 = address2;
}

@JsonProperty("street")
public String getStreet() {
return street;
}

@JsonProperty("street")
public void setStreetName(String street) {
this.street = street;
}


@JsonProperty("city")
public String getCity() {
return city;
}

@JsonProperty("city")
public void setCity(String city) {
this.city = city;
}

@JsonProperty("pinCode")
public String getPinCode() {
return pinCode;
}

@JsonProperty("pinCode")
public void setpinCode(String pinCode) {
this.pinCode = pinCode;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}
