package com.rt.vehicleEntryServiceInterface;

import com.rt.vehicleEntryDTO.UpdateVehicleInfoReqDto;
import com.rt.vehicleEntryDTO.UpdateVehicleInfoRespDto;

public interface UpdateAndDeleteVehicleInfoInterface {
	
	boolean updateVehicleInfo(UpdateVehicleInfoReqDto updateVehicleInfoReqDto);
	
	void deleteVehicleInfo(int id);
	
	UpdateVehicleInfoRespDto fetchVehicleDataUsingId(int id);

}
