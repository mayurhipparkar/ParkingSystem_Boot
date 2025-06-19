package com.rt.vehicleEntryRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rt.vehicleEntryEntity.AddVehicle;
@Repository
public interface VehicleEntryRepo extends JpaRepository<AddVehicle,Integer>{

}
