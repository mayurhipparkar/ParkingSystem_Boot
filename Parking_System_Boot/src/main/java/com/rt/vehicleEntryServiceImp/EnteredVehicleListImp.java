package com.rt.vehicleEntryServiceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rt.vehicleEntryDTO.ReqAddVehicleDto;
import com.rt.vehicleEntryDTO.RespAddVehicleDto;
import com.rt.vehicleEntryDTO.RespEnteredVehicleListDTO;
import com.rt.vehicleEntryEntity.AddVehicle;
import com.rt.vehicleEntryRepository.EnteredVehicleRepository;
import com.rt.vehicleEntryServiceInterface.EnteredVehicleListInterface;

@Service
public class EnteredVehicleListImp implements EnteredVehicleListInterface{

	@Autowired
	private EnteredVehicleRepository enteredVehicleRepository;
	
	
	@Override
	public List<RespEnteredVehicleListDTO>  twoWheelerList() {
		
		 List<AddVehicle> vehicleList = enteredVehicleRepository.findAll();// it gets the all record from database 
		 
		 List<RespEnteredVehicleListDTO> dtoList = new ArrayList<>();// it is used to gather Entity to DTO converted data 

		    for (AddVehicle vehicle : vehicleList) {
		    	
		    	RespEnteredVehicleListDTO dto = new RespEnteredVehicleListDTO();// this is origin DTO
		    	
		    	System.out.println("inside forEach loop for retrieving list of data :"+vehicle.getId());
		        dto.setEntry_id(vehicle.getId());
		        dto.setVehicle_type(vehicle.getVehicleType());
		        dto.setVehicle_number(vehicle.getVehicleNumber());
		        dto.setOwner_name(vehicle.getOwnerName());
		        dto.setContact_number(vehicle.getContactNumber());
		        dto.setEntry_date(vehicle.getEntryDate());
		        dto.setEntry_time(vehicle.getEntryTime());
		        
		        dtoList.add(dto);
		    }

		    return dtoList;
		}

		

	@Override
	public List<RespEnteredVehicleListDTO> fourWheelerList() {
		return null;
		
		
	}

}
