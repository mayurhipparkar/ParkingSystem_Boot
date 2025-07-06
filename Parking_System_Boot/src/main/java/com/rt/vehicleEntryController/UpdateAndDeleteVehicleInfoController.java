package com.rt.vehicleEntryController;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rt.vehicleEntryDTO.UpdateVehicleInfoReqDto;
import com.rt.vehicleEntryDTO.UpdateVehicleInfoRespDto;
import com.rt.vehicleEntryServiceInterface.UpdateAndDeleteVehicleInfoInterface;

@RestController
@RequestMapping("/update")
public class UpdateAndDeleteVehicleInfoController {
	
	@Autowired
	private UpdateAndDeleteVehicleInfoInterface updateAndDeleteVehicleInfoInterface;
	
	//mapped for update existing vehicle record.
	@PostMapping("/update-vehicle")
	public boolean updateVehicleInfo(@RequestBody UpdateVehicleInfoReqDto updateVehicleInfoReqDto) {
		boolean updatedData=updateAndDeleteVehicleInfoInterface.updateVehicleInfo(updateVehicleInfoReqDto);
		return updatedData;
		
	}

	//it is used to get data using by id and send data to javascript async await.
	@CrossOrigin(origins = "http://localhost:8282")
	 @GetMapping("/fetch/{id}")
	    public UpdateVehicleInfoRespDto getStudentById(@PathVariable int id) {
		 
		return updateAndDeleteVehicleInfoInterface.fetchVehicleDataUsingId(id);
	    }
	
//mapped for delete vehicle using id.
	@DeleteMapping("/delete-vehicle")
	public void deleteVehicleInfo(@RequestParam int id) {
		updateAndDeleteVehicleInfoInterface.deleteVehicleInfo(id);
		
		
	}

}
