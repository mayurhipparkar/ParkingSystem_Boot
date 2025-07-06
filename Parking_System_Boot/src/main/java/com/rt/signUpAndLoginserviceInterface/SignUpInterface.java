package com.rt.signUpAndLoginserviceInterface;

import org.springframework.stereotype.Service;

import com.rt.signUpAndLoginDTO.RequestSignUpDTO;
@Service
public interface SignUpInterface {
	
	boolean addUser(RequestSignUpDTO signUpDto);

}
