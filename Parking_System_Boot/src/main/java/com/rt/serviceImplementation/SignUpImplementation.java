package com.rt.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.DTO.RequestSignUpDTO;
import com.rt.Dao.SignupRepositiry;
import com.rt.entity.User;
import com.rt.mapper.SignUpAndUserMapper;
import com.rt.serviceInterface.SignUpInterface;

@Service
public class SignUpImplementation implements SignUpInterface{
	@Autowired
	private SignupRepositiry userRepo;//it extended the JPA repository 
	
	@Autowired
	private SignUpAndUserMapper mapper;//Mapper class to convert DTO to Entity and vis versa.

	@Override
	public boolean addUser(RequestSignUpDTO signUpDto) {
		
		long userCount =userRepo.checkUserCount(signUpDto.getEmail());
		if(userCount>=1) {
			System.out.println("user already exixt");
			return false;
		}
		
		
		User user=mapper.toEntity(signUpDto);//converting to DTO to Entity.
		User result=userRepo.save(user);
		System.out.println("user added successfully");
		if(result!=null) {
		return true;
		
		}
		return false;
		
		
		
		
		
		
	}

}
