package com.rt.signUpAndLoginMapper;

import org.springframework.stereotype.Component;

import com.rt.signUpAndLoginDTO.RequestSignUpDTO;
import com.rt.signUpAndLoginDTO.ResponseSignUpDTO;
import com.rt.signUpAndLoginEntity.User;

@Component
public class SignUpAndUserMapper {
	
	public ResponseSignUpDTO toDTO(User user) {
		
		return new ResponseSignUpDTO(user.getId(),user.getFullname(),user.getEmail(),user.getAddress(),user.getPassword(),user.getRole());
		
	}

	
public  User toEntity(RequestSignUpDTO signDto) {
		
		return new User(signDto.getFullname(),signDto.getEmail(),signDto.getNumber(),signDto.getAddress(),signDto.getPassword(),signDto.getRole());
		
	}

}
