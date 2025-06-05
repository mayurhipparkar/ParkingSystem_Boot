package com.rt.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseSignUpDTO {
	private int id;
	
	private String fullname;
	
	private String email;
		  
	private String number;
		  
	private String address;
		  	
	private String role;

	public ResponseSignUpDTO(String fullname, String email, String number, String address,String role) {
		super();
		this.fullname = fullname;
		this.email = email;
		this.number = number;
		this.address = address;
		this.role = role;
	}
	
	
	

}
