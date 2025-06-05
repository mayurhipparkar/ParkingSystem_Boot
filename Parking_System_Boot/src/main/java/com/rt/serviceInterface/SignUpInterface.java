package com.rt.serviceInterface;

import org.springframework.stereotype.Service;

import com.rt.DTO.RequestSignUpDTO;
@Service
public interface SignUpInterface {
	
	boolean addUser(RequestSignUpDTO signUpDto);

}
