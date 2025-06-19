package com.rt.vehicleEntryServiceInterface;

import java.util.List;

import com.rt.vehicleEntryDTO.RespEnteredVehicleListDTO;

public interface EnteredVehicleListInterface {
	List<RespEnteredVehicleListDTO> twoWheelerList();
	List<RespEnteredVehicleListDTO>  fourWheelerList();

}
