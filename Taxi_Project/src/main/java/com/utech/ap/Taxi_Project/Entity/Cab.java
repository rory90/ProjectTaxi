package com.utech.ap.Taxi_Project.Entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity(name="ata_tbl_Cab")
public class Cab {
	
	@Column(name="Cab_name")
	private String cabName;
	@Id
	@Column(name="cab_number")
	private String cabNumber;
	@Column(name="seating_capacity")
	private int seatingCapacity;
	@Column(name="vehicle_type")
	private String vehicleType;
	@Column(name="fare_per_km")
	private float farePerKM;
	
	public String getCabName() {
		return cabName;
	}
	public void setCabName(String cabName) {
		this.cabName = cabName;
	}
	public String getCabNumber() {
		return cabNumber;
	}
	public void setCabNumber(String cabNumber) {
		this.cabNumber = cabNumber;
	}
	public int getSeatingCapacity() {
		return seatingCapacity;
	}
	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public float getFarePerKM() {
		return farePerKM;
	}
	public void setFarePerKM(float farePerKM) {
		this.farePerKM = farePerKM;
	}
	
	

	
	
	
	
	
}