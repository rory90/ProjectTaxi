package com.utech.ap.Taxi_Project.Service.Administrator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.utech.ap.Taxi_Project.Entity.Cab;
import com.utech.ap.Taxi_Project.Database.Administrator.Cabdb;

@Component 
public class CabService {

	@Autowired
	Cabdb da;
	public String addVehicle(Cab vehicle){
		if(vehicle ==null)
			return "FAIL";
		else if(vehicle.getCabNumber()==null){
			return "FAIL";
		}
			else
			{
				return da.addVehicle(vehicle);
			}
		}


	public Cab ViewVehicle(String Cabnumber){

		return da.ViewVehicle(Cabnumber);
	}

public String ModifyVehicle(Cab vehicle){
		return da.ModifyVehicle(vehicle);

	}


public String ConfirmDeleteVehicle(Cab vehicle){

	return da.ConfirmDeleteVehicle(vehicle);
}

public List<Cab> displayall()
{
	return da.displayall();
}

}
