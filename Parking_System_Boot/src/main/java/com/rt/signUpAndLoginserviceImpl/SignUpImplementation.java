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
	public String addUser(RequestSignUpDTO signUpDto) { 
	    User user=mapper.toEntity(signUpDto);//converting to DTO to Entity.

	    if ("Admin".equalsIgnoreCase( signUpDto.getRole())) {
	        // Check if any Admin exists already
	        boolean adminExists = userRepo.existsByRoleIgnoreCase("Admin");

	        if (adminExists) {
	            // check if same email with admin role.
	            User existing = userRepo.findByEmailAndRole(signUpDto.getEmail(), "Admin");
	            if (existing != null) {
	                return "Admin already exists with this email.";
	            }
	            return "Only one Admin allowed.";
	        }

	        // No admin found,save new admin.
	        userRepo.save(user);
	        return "Admin registered successfully,now able to login.";
	    } else {
	        // For non-admin roles, check only email
	        boolean emailExists = userRepo.existsByEmailIgnoreCase(signUpDto.getEmail());

	        if (emailExists) {
	            return "Email already exists.";
	        }
	        // save user
	        userRepo.save(user);
	        return "User registered successfully,now able to login.";
	    }
	}

}
