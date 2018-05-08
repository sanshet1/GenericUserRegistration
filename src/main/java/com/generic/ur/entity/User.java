package com.generic.ur.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.dozer.Mapping;

import com.fasterxml.jackson.annotation.JsonManagedReference;
@Table(name="user")
@Entity
public class User {
	
	
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Id
	private long id;
	
	@NotNull
	private String userFirstName;
	
	@NotNull
	private String userMiddleName;
	
	@NotNull
	private String userLastName;
	
	@NotNull
	@Column(unique=true)
	private String userId;
	
	@NotNull
	@Size(min=5,max=10, message="Password should be in bewtwwen 5 to 10 in length")
	private String password;
	
	@NotNull
	@Mapping("userAddressDTO")
	@JsonManagedReference 
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<UserAddress> userAddress;

	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getUserMiddleName() {
		return userMiddleName;
	}
	public void setUserMiddleName(String userMiddleName) {
		this.userMiddleName = userMiddleName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public List<UserAddress> getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(List<UserAddress> userAddress) {
		this.userAddress = userAddress;
	}
	
}
