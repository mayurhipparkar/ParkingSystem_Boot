package com.rt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
	 @Id
	 @GeneratedValue(strategy =GenerationType.AUTO)
	private int id;
	 
	 @Column(name = "fullname", nullable = false)
	private String fullname;
	 
	  @Column(name = "email", nullable = false, unique = true)
	private String email;
	  
	  @Column(name = "number", nullable = false)
	private String number;
	  
	  @Column(name = "address")
	private String address;
	  
	  @Column(name = "password", nullable = false)
	private String password;
	  	
	  @Column(name = "role",nullable = false)
	private String role;

	public User(String fullname, String email, String number, String address, String password, String role) {
		super();
		this.fullname = fullname;
		this.email = email;
		this.number = number;
		this.address = address;
		this.password = password;
		this.role = role;
	}
	
	
	
	
}
