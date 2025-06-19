package com.rt.vehicleEntryController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rt.vehicleEntryDTO.ReqAddVehicleDto;
import com.rt.vehicleEntryDTO.RespAddVehicleDto;
import com.rt.vehicleEntryServiceInterface.VehicleEntryInterface;

@RestController
@RequestMapping("/entry")
public class VehicleEntry {
	
	@Autowired
	private VehicleEntryInterface vehicleEntryInterface ;
	
	@PostMapping("/addVehicle")
	public RespAddVehicleDto addVehicleInfo(@RequestBody ReqAddVehicleDto reqAddVehicleDto) {
		System.out.println(reqAddVehicleDto.getSessionLogedUserId()+" "+reqAddVehicleDto.getVehicleNumber()+" "+reqAddVehicleDto.getEntryDate()+" "+reqAddVehicleDto.getEntryTime());
		RespAddVehicleDto respDto=vehicleEntryInterface.addVehicleInfo(reqAddVehicleDto);
		
		return respDto;
		
	}

}
