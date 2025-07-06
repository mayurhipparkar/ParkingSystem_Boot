package com.rt.vehicleEntryServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.vehicleEntryDTO.UpdateVehicleInfoReqDto;
import com.rt.vehicleEntryDTO.UpdateVehicleInfoRespDto;
import com.rt.vehicleEntryEntity.Vehicle;
import com.rt.vehicleEntryMapper.UpdateVehicleInfoMapper;
import com.rt.vehicleEntryRepository.UpdateAndDeleteVehicleInfoRepo;
import com.rt.vehicleEntryServiceInterface.UpdateAndDeleteVehicleInfoInterface;

@Service
public class UpdateAndDeleteVehicleInfoImp implements UpdateAndDeleteVehicleInfoInterface{
@Autowired
private UpdateAndDeleteVehicleInfoRepo updateAndDeleteVehicleInfoRepo;
	@Autowired
	private UpdateVehicleInfoMapper updateVehicleInfoMapper;
	
	// it is used to update existing vehicle record and display the change.
	@Override
	public boolean updateVehicleInfo(UpdateVehicleInfoReqDto updateVehicleInfoReqDto) {
		Vehicle vehicle=updateVehicleInfoMapper.toEntity(updateVehicleInfoReqDto);
		Vehicle updatedData=updateAndDeleteVehicleInfoRepo.save(vehicle);
		if(updatedData!=null) {
			System.out.println("after updation id :"+updatedData.getId()+" "+" before updation id :"+updateVehicleInfoReqDto.getId());
			return true;
		}
		
		return false;
	}
	
	//it is used to delete vehicle info using id.
	@Override
	public void deleteVehicleInfo(int id) {
		
		if(updateAndDeleteVehicleInfoRepo.existsById(id)) {
		updateAndDeleteVehicleInfoRepo.deleteById(id);
		System.out.println("Vehicle with ID "+ id+" deleted");
		return;
		}
		System.out.println("Vehicle with ID "+ id+" does not exist");
	}

	//it is used to get data using by id and send data to javascript async await.
	public UpdateVehicleInfoRespDto fetchVehicleDataUsingId(int id) {
		Optional<Vehicle> repoData=updateAndDeleteVehicleInfoRepo.findById(id);
		if(repoData.isPresent()) {
			Vehicle data=repoData.get();
			UpdateVehicleInfoRespDto fetchedData=updateVehicleInfoMapper.toDTO(data);
			return fetchedData;
		}
		return null;
		
	}
}
