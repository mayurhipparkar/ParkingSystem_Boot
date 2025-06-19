package com.rt.vehicleEntryRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rt.vehicleEntryEntity.AddVehicle;

public interface EnteredVehicleRepository extends JpaRepository<AddVehicle,Integer>{
	 
	List<AddVehicle> findAll();

}
