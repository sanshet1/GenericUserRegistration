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
	private String type;
	
	@NotNull
	private String address1;

	
	
	private String address2;
	
	@NotNull
	private String street;
	
	@NotNull
	
	private String city;
	
	@NotNull
	private String pinCode;
	
	public UserAddress()
	{
	
	}

	public UserAddress(long addressId, User user, String type,String address1,String address2,String street,  String city,String pinCode) {
		super();
		this.addressId = addressId;
		this.user = user;
		this.type = type;
		this.address1 = address1;
		this.address2 = address2;
		this.street = street;
		this.city = city;
		this.pinCode = pinCode;
	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	

}
