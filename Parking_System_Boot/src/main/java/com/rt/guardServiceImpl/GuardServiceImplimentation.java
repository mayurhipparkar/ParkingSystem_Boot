package com.rt.guardServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.guardDTO.AddGuardReqDTO;
import com.rt.guardMapper.GuardMapper;
import com.rt.guardRepository.GuardRepository;
import com.rt.guardServiceInterface.GuardServiceInterface;
import com.rt.userEntity.Users;
@Service
public class GuardServiceImplimentation implements GuardServiceInterface{
	@Autowired
	private GuardRepository guardRepository;
	
	@Autowired
	private GuardMapper guardMapper;

	@Override
	public String addGuard(AddGuardReqDTO addGuardReqDTO) {
	    
	    // Map DTO to entity
	    Users users = guardMapper.toEntity(addGuardReqDTO);

	    // Set default role if not provided
	    if (users.getRole() == null || users.getRole().trim().isEmpty()) {
	        users.setRole("Guard");
	    }

	    // Set default status if not provided
	    if (users.getStatus() == null || users.getStatus().trim().isEmpty()) {
	        users.setStatus("Active");
	    }

	    // Check if role is 'Guard' only
	    if (!"Guard".equalsIgnoreCase(users.getRole())) {
	        return "Only 'Guard' role is allowed!";
	    }

	    // Check if email already exists
	    boolean emailExists = guardRepository.existsByEmailIgnoreCase(addGuardReqDTO.getEmail());
	    if (emailExists) {
	        return "Email already exists...!";
	    }

	    // Save to DB
	    guardRepository.save(users);
	    return "Successful...!";
	}

}
