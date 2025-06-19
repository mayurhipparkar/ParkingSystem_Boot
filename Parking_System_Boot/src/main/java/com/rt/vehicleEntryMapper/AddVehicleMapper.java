package com.rt.vehicleEntryMapper;

import org.springframework.stereotype.Component;

import com.rt.vehicleEntryDTO.ReqAddVehicleDto;
import com.rt.vehicleEntryDTO.RespAddVehicleDto;
import com.rt.vehicleEntryEntity.AddVehicle;

@Component
public class AddVehicleMapper {
	
	public RespAddVehicleDto toDTO(AddVehicle addVehicle) {
		return new RespAddVehicleDto(addVehicle.getVehicleType(),addVehicle.getVehicleNumber(),addVehicle.getOwnerName(),addVehicle.getContactNumber(),addVehicle.getEntryDate(),addVehicle.getEntryTime());
		
		
	}
	
	public AddVehicle toEntity(ReqAddVehicleDto reqAddVehicleDto) {
		return new AddVehicle(reqAddVehicleDto.getVehicleType(),reqAddVehicleDto.getVehicleNumber(),reqAddVehicleDto.getOwnerName(),reqAddVehicleDto.getContactNumber(),reqAddVehicleDto.getEntryDate(),reqAddVehicleDto.getEntryTime(),reqAddVehicleDto.getSessionLogedUserId());
		
		
	}

}
