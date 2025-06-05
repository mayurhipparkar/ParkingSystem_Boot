package com.rt.mapper;

import org.springframework.stereotype.Component;

import com.rt.DTO.RequestSignUpDTO;
import com.rt.DTO.ResponseSignUpDTO;
import com.rt.entity.User;

@Component
public class SignUpAndUserMapper {
	
	public ResponseSignUpDTO toDTO(User user) {
		
		return new ResponseSignUpDTO(user.getId(),user.getFullname(),user.getEmail(),user.getAddress(),user.getPassword(),user.getRole());
		
	}

	
public  User toEntity(RequestSignUpDTO signDto) {
		
		return new User(signDto.getFullname(),signDto.getEmail(),signDto.getNumber(),signDto.getAddress(),signDto.getPassword(),signDto.getRole());
		
	}

}
