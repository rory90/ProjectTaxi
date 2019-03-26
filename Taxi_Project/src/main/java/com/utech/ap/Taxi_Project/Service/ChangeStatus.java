package com.utech.ap.Taxi_Project.Service;

import com.utech.ap.Taxi_Project.Database.CabDb;
import com.utech.ap.Taxi_Project.Database.CabDbImpl;

public class ChangeStatus {

	
public void updateStatus(int cabId, boolean toChange) {
		
		CabDb cabDao = new CabDbImpl();
		cabDao.changeCabStatus(cabId, toChange);
}
}
