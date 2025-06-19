package com.rt.vehicleEntryServiceInterface;

import com.rt.vehicleEntryDTO.ReqAddVehicleDto;
import com.rt.vehicleEntryDTO.RespAddVehicleDto;

public interface VehicleEntryInterface {
	
	RespAddVehicleDto addVehicleInfo(ReqAddVehicleDto reqAddVehicleDto);

}
