
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
"flatNumber",
"buildingName",
"streetName",
"landMark",
"city",
"district",
"state",
"country",
"zipCode"
})
public class UserAddressDTO {

@NotNull
@Size(min=1,max=1, message=" Type should be only 1 character")
@JsonProperty("type")
private String type;
@NotNull
@Size(min=1,max=20, message="Flat number should be between 1 to 20 character")
@JsonProperty("flatNumber")
private String flatNumber;

@NotNull
@Size(min=1,max=30, message="Building name should be between 1 to 30 character")
@JsonProperty("buildingName")
private String buildingName;

@Size(max=30, message="Street name should be maximum of 30 character")
@JsonProperty("streetName")
private String streetName;

@Size(max=50, message="Landmark should be maximum of 30 character")
@JsonProperty("landMark")
private String landMark;

@NotNull
@Size(min=1,max=20, message="City name should be between 1 to 20 character")
@JsonProperty("city")
private String city;

@NotNull
@Size(min=2,max=30, message="Distict name should be between 1 to 30 character")
@JsonProperty("district")
private String district;

@NotNull
@Size(min=2,max=20, message="State name should be between 1 to 20 character")
@JsonProperty("state")
private String state;

@NotNull
@Size(min=5,max=30, message="Country name should be between 1 to 30 character")
@JsonProperty("country")
private String country;

@NotNull
@Size(min=6,max=8, message="Zipcode should be between 6 to 8 character")
@JsonProperty("zipCode")
private String zipCode;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public UserAddressDTO()
{
	
}


public UserAddressDTO(String type, String flatNumber, String buildingName,String streetName,
		 String landMark, String city,String district,String state,String country, String zipCode
		) {
	super();
	this.type = type;
	this.flatNumber = flatNumber;
	this.buildingName = buildingName;
	this.streetName = streetName;
	this.landMark = landMark;
	this.city = city;
	this.district = district;
	this.state = state;
	this.country = country;
	this.zipCode = zipCode;
	
}

@JsonProperty("type")
public String getType() {
return type;
}

@JsonProperty("type")
public void setType(String type) {
this.type = type;
}

@JsonProperty("flatNumber")
public String getFlatNumber() {
return flatNumber;
}

@JsonProperty("flatNumber")
public void setFlatNumber(String flatNumber) {
this.flatNumber = flatNumber;
}

@JsonProperty("buildingName")
public String getBuildingName() {
return buildingName;
}

@JsonProperty("buildingName")
public void setBuildingName(String buildingName) {
this.buildingName = buildingName;
}

@JsonProperty("streetName")
public String getStreetName() {
return streetName;
}

@JsonProperty("streetName")
public void setStreetName(String streetName) {
this.streetName = streetName;
}

@JsonProperty("landMark")
public String getLandMark() {
return landMark;
}

@JsonProperty("landMark")
public void setLandMark(String landMark) {
this.landMark = landMark;
}

@JsonProperty("city")
public String getCity() {
return city;
}

@JsonProperty("city")
public void setCity(String city) {
this.city = city;
}

@JsonProperty("district")
public String getDistrict() {
return district;
}

@JsonProperty("district")
public void setDistrict(String district) {
this.district = district;
}

@JsonProperty("state")
public String getState() {
return state;
}

@JsonProperty("state")
public void setState(String state) {
this.state = state;
}

@JsonProperty("country")
public String getCountry() {
return country;
}

@JsonProperty("country")
public void setCountry(String country) {
this.country = country;
}

@JsonProperty("zipCode")
public String getZipCode() {
return zipCode;
}

@JsonProperty("zipCode")
public void setZipCode(String zipCode) {
this.zipCode = zipCode;
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
