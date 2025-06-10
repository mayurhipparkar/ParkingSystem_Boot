package com.rt.controller;

import org.springframework.web.bind.annotation.RestController;

import com.rt.DTO.RequestLoginDTO;
import com.rt.DTO.RequestSignUpDTO;
import com.rt.DTO.ResponseLoginDTO;
import com.rt.serviceImplementation.LoginServiceImplementation;
import com.rt.serviceImplementation.SignUpImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/main")
public class SignUpAndLoginApiController {
	//sign-up logic start.
	@Autowired
	private SignUpImplementation signUpService;
	
	@PostMapping("/signup")
	public boolean data(@RequestBody RequestSignUpDTO signUpDto) {
		boolean userStatus=signUpService.addUser(signUpDto);
		System.out.println(signUpDto.getFullname()+" "+signUpDto.getEmail()+" "+signUpDto.getNumber()+" "+signUpDto.getAddress()+" "+signUpDto.getPassword()+" "+signUpDto.getRole());
		return userStatus;
		
	}
	//sign-up logic end.
	
	//login logic start.
	@Autowired
	private LoginServiceImplementation loginService;
	
	@PostMapping("/login")
	public ResponseLoginDTO checkLogin(@RequestBody RequestLoginDTO loginDto) {
		ResponseLoginDTO userInfo=loginService.checkLogin(loginDto);
		System.out.println(loginDto.getEmail()+" "+loginDto.getPassword());
		
		if(userInfo!=null) {
		return userInfo;
		} 
		return null;
		
	}
	//login logic end.
	

}
