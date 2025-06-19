package com.rt.vehicleEntryController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rt.vehicleEntryDTO.RespEnteredVehicleListDTO;
import com.rt.vehicleEntryServiceInterface.EnteredVehicleListInterface;


@RestController
@RequestMapping("/list")
public class EnteredVehicleListController {
	
	@Autowired
	private EnteredVehicleListInterface enteredVehicleListInterface;
	
	@GetMapping("/vehicleList")
    public List<RespEnteredVehicleListDTO> getAllProducts() {
        return enteredVehicleListInterface.twoWheelerList();
    }
}
