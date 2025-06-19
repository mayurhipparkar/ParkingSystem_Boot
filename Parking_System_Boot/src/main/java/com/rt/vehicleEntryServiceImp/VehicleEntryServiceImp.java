package com.rt.vehicleEntryServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rt.vehicleEntryDTO.ReqAddVehicleDto;
import com.rt.vehicleEntryDTO.RespAddVehicleDto;
import com.rt.vehicleEntryEntity.AddVehicle;
import com.rt.vehicleEntryMapper.AddVehicleMapper;
import com.rt.vehicleEntryRepository.VehicleEntryRepo;
import com.rt.vehicleEntryServiceInterface.VehicleEntryInterface;

@Service
public class VehicleEntryServiceImp implements VehicleEntryInterface{
	@Autowired
	private  VehicleEntryRepo vehicleEntryRepo;
	
	@Autowired
	private  AddVehicleMapper addVehicleMapper;

	@Override
	public RespAddVehicleDto addVehicleInfo(ReqAddVehicleDto reqAddVehicleDto) {
		AddVehicle vehicleEntity=addVehicleMapper.toEntity(reqAddVehicleDto);
		
		AddVehicle vehicleInfo=vehicleEntryRepo.save(vehicleEntity);
		
		RespAddVehicleDto vehicleRespDto=addVehicleMapper.toDTO(vehicleInfo);
		
		return vehicleRespDto;
	}

	
}
