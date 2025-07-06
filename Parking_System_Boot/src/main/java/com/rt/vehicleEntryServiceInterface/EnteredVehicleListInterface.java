package com.rt.vehicleEntryServiceInterface;

import org.springframework.data.domain.Page;

import com.rt.vehicleEntryDTO.EnteredVehicleListRespDTO;

public interface EnteredVehicleListInterface {

	Page<EnteredVehicleListRespDTO> getVehiclesByType(String vehicleType, int page, int size);
	
}
