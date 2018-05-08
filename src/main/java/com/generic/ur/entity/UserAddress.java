package com.generic.ur.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Table(name="user_addr")
@Entity
public class UserAddress {
	
	
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Id
	private long addressId;
	@JsonBackReference 
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
	private User user;
	
	@NotNull
	@Size(min=1,max=1, message=" Type should be only 1 character")
	private String type;
	
	@NotNull
	@Size(min=1,max=20, message="Flat number should be between 1 to 20 character")
	private String flatNumber;

	@NotNull
	@Size(min=1,max=30, message="Building name should be between 1 to 30 character")
	private String buildingName;
	
	@Size(max=30, message="Street name should be maximum of 30 character")
	private String streetName;
	
	@Size(max=50, message="Landmark should be maximum of 30 character")
	private String landMark;
	
	@NotNull
	@Size(min=1,max=20, message="City name should be between 1 to 20 character")
	private String city;
	
	@NotNull
	@Size(min=2,max=30, message="Distict name should be between 1 to 30 character")
	private String district;
	@NotNull
	@Size(min=2,max=20, message="State name should be between 1 to 20 character")
	private String state;
	
	@NotNull
	@Size(min=5,max=30, message="Country name should be between 1 to 30 character")
	private String country;
	
	@NotNull
	@Size(min=6,max=8, message="Zipcode should be between 6 to 8 character")
	private String zipCode;
	
	public UserAddress()
	{
	
	}

	public UserAddress( User user, String type, String flatNumber, String buildingName,
			String streetName, String lanndMark, String city, String district, String state, String country,
			String zipCode) {
		super();
		this.user = user;
		this.type = type;
		this.flatNumber = flatNumber;
		this.buildingName = buildingName;
		this.streetName = streetName;
		this.landMark = lanndMark;
		this.city = city;
		this.district = district;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
	}
	
	public long getAddressId() {
		return addressId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFlatNumber() {
		return flatNumber;
	}
	public void setFlatNumber(String flatNumber) {
		this.flatNumber = flatNumber;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getLandMark() {
		return landMark;
	}
	public void setLandMark(String lanndMark) {
		this.landMark = lanndMark;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	
	

}
