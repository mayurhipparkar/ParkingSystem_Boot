package com.rt.vehicleEntryServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rt.vehicleEntryDTO.EnteredVehicleListRespDTO;
import com.rt.vehicleEntryEntity.Vehicle;
import com.rt.vehicleEntryRepository.EnteredVehicleRepository;
import com.rt.vehicleEntryServiceInterface.EnteredVehicleListInterface;

@Service
public class EnteredVehicleListImp implements EnteredVehicleListInterface{

	@Autowired
	private EnteredVehicleRepository enteredVehicleRepository;

	@Override
	public Page<EnteredVehicleListRespDTO> getVehiclesByType(String vehicleType, int page, int size) {
		 Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
	        Page<Vehicle> pagedResult = enteredVehicleRepository.findByVehicleType(vehicleType, pageable);

	        return pagedResult.map(vehicle -> new EnteredVehicleListRespDTO(
	                vehicle.getId(),
	                vehicle.getVehicleType(),
	                vehicle.getVehicleNumber(),
	                vehicle.getOwnerName(),
	                vehicle.getContactNumber(),
	                vehicle.getEntryDate(),
	                vehicle.getEntryTime()
	        ));
	    	}

}
