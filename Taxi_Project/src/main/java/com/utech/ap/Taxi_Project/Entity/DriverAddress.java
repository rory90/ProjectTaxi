package com.utech.ap.Taxi_Project.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="ata_tbl_driver_address")
public class DriverAddress {

	
	@Id
	@Column(name="driver_id",length=20)
	private String driverid;
    @Column(name="house_number",length=20)
    private int houseNumber;
    @Column(name="first_line_of_address" ,length=20)
    private String firstLineOfAddress;
    @Column(name="second_Line_Of_Address",length=20)
    private String  secondLineOfAddress;
    @Column(name="city",length=20)
	private String city;
    @Column(name="parish",length=20)
	private String state;
    public String getDriverid() {
		return driverid;
	}
	public void setDriverid(String driverid) {
		this.driverid = driverid;
	}
	public int getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getFirstLineOfAddress() {
		return firstLineOfAddress;
	}
	public void setFirstLineOfAddress(String firstLineOfAddress) {
		this.firstLineOfAddress = firstLineOfAddress;
	}
	public String getSecondLineOfAddress() {
		return secondLineOfAddress;
	}
	public void setSecondLineOfAddress(String secondLineOfAddress) {
		this.secondLineOfAddress = secondLineOfAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getParish() {
		return state;
	}
	public void setParish(String state) {
		this.state = state;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	@Column(name="pin_code",length=20)
	private String pinCode;
}
