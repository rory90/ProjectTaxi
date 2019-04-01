package com.utech.ap.Taxi_Project.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity(name="ata_tbl_Customer_address")

public class CustomerAddresse {
	
	 @Id
     @Column(name="login_id")
		private String loginid;
     @Column(name="house_number")
     private int houseNumber;
     @Column(name="first_line_of_address")
	    private String firstLineOfAddress;
     @Column(name="second_line_of_address")
     private String  secondLineOfAddress;
     @Column(name="city")
		private String city;
     @Column(name="parish")
		private String parish;
     @Column(name="pin_code")
		private String pinCode;
		
     
     public String getLoginid() {
			return loginid;

     }
     public void setLoginid(String loginid) {
			this.loginid = loginid;
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
			return parish;
		}
	public void setState(String parish) {
			this.parish= parish;
		}
	
	public String getPinCode() {
			return pinCode;
		}
	public void setPinCode(String pinCode) {
			this.pinCode = pinCode;
		}
		
		





}
