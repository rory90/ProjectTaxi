package com.utech.ap.Taxi_Project.Service.Administrator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.utech.ap.Taxi_Project.Entity.DriverAddress;
import com.utech.ap.Taxi_Project.Entity.Driver;
import com.utech.ap.Taxi_Project.Entity.Cab;
import com.utech.ap.Taxi_Project.Database.Administrator.Driverdb;

@Component 
public class DriverService {
	
	@Autowired
	Driverdb db;
	public String addDriver(Driver driver, DriverAddress da){

		if(driver==null||da==null)
			return "FAIL";
		 else if(driver.getFirstName()==null
				||driver.getLastName()==null
				||driver.getLicenseNumber()==null
				||driver.getContactNumber()==null
				||driver.getCabNumber()==null
				||da.getHouseNumber()==0
				||da.getFirstLineOfAddress()==null
				||da.getSecondLineOfAddress()==null
				||da.getCity()==null
			    ||da.getState()==null
			    ||da.getPinCode()==null){
			return "FAIL";
		}
			else
			{
				return db.addDriver(driver,da);
			}
		}
	public Object[] viewDriver(String cabNumber){
		return db.viewDriver(cabNumber);
	}


	public String modifyDriver(Driver driver, DriverAddress da){
		return db.modifyDriver(driver, da);
	}

	public String deleteDriver(Driver driver, DriverAddress da){
		return db.deleteDriver(driver, da);
	}
	public ArrayList<Object[]> displayall(){
		return db.displayall();
	}

}
