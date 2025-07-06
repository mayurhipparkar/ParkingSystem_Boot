package com.rt.signUpAndLoginserviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.signUpAndLoginDTO.RequestSignUpDTO;
import com.rt.signUpAndLoginEntity.User;
import com.rt.signUpAndLoginMapper.SignUpAndUserMapper;
import com.rt.signUpAndLoginRepository.SignupRepositiry;
import com.rt.signUpAndLoginserviceInterface.SignUpInterface;

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
