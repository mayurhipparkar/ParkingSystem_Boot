package com.rt.vehicleEntryRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rt.vehicleEntryEntity.Vehicle;

public interface EnteredVehicleRepository extends JpaRepository<Vehicle,Integer>{

	Page<Vehicle> findByVehicleType(String vehicleType, Pageable pageable);

}
