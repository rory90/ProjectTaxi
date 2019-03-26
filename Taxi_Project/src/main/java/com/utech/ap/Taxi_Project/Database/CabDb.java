package com.utech.ap.Taxi_Project.Database;


import com.utech.ap.Taxi_Project.Entity.Cab;

public interface CabDb {
	
	
	public void addCab(Cab cab);

	public int getCabId();
	
	public void changeCabStatus(int cabId, boolean i);

}
