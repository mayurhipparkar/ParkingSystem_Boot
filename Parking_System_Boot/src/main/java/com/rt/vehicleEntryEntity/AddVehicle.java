package com.rt.vehicleEntryEntity;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="vehicle_entries")
public class AddVehicle {
	@Id
	 @GeneratedValue(strategy =GenerationType.AUTO)
	private int id;
	
	 @Column(name = "vehicle_type", nullable = false)
	private String vehicleType;
	 
	 @Column(name = "vehicle_number", nullable = false)
	private String vehicleNumber;
	 
	 @Column(name = "owner_name", nullable = false)
	private String ownerName;
	 
	 @Column(name = "contact_number", nullable = false)
	private String contactNumber;
	
	 @Column(name = "entry_date", nullable = false)
	private LocalDate entryDate;
	
	 @Column(name = "entry_time", nullable = false)
	private LocalTime entryTime;
	 
	 @Column(name = "user_id", nullable = false)
	 private int sessionLogedUserId; 
	
	 public AddVehicle(String vehicleType, String vehicleNumber, String ownerName, String contactNumber,
			LocalDate entryDate, LocalTime entryTime, int sessionLogedUserId) {
		super();
		this.vehicleType = vehicleType;
		this.vehicleNumber = vehicleNumber;
		this.ownerName = ownerName;
		this.contactNumber = contactNumber;
		this.entryDate = entryDate;
		this.entryTime = entryTime;
		this.sessionLogedUserId = sessionLogedUserId;
	}
	 
	 

}
