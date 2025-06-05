package com.rt.serviceImplementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.DTO.RequestLoginDTO;
import com.rt.DTO.ResponseLoginDTO;
import com.rt.Dao.LoginRepository;
import com.rt.serviceInterface.LoginServiceInterface;

@Service
public class LoginServiceImplementation implements LoginServiceInterface{

	@Autowired
	private LoginRepository loginRepo;//it extended the JPA repository 
	
	@Override
	public ResponseLoginDTO checkLogin(RequestLoginDTO reqLoginDto) {
		Optional<ResponseLoginDTO> optional = loginRepo.loginUser(reqLoginDto.getEmail(),reqLoginDto.getPassword());
		
		if (optional.isPresent()) {
			ResponseLoginDTO respLoginDto = optional.get();
			
			System.out.println("this is an optional interface which returning login value "+respLoginDto.getFullname());
			
			return respLoginDto;
		}
		
		return null;
		
		
		
	}
	
}
