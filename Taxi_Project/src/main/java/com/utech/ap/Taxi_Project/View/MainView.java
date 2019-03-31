package com.utech.ap.Taxi_Project.View;

import com.utech.ap.Taxi_Project.Database.CabDb;
import com.utech.ap.Taxi_Project.Database.CabDbImpl;
import com.utech.ap.Taxi_Project.Database.CustomerDbImpl;
import com.utech.ap.Taxi_Project.Database.CustomerDb;
import com.utech.ap.Taxi_Project.Database.BookingDb;
import com.utech.ap.Taxi_Project.Database.BookingDbImpl;
import com.utech.ap.Taxi_Project.Database.BookingHelperDb;
import com.utech.ap.Taxi_Project.Database.BookingHelperDbImpl;
import com.utech.ap.Taxi_Project.Entity.Booking;
import com.utech.ap.Taxi_Project.Entity.Cab;
import com.utech.ap.Taxi_Project.Entity.Customer;
import com.utech.ap.Taxi_Project.Helper.DbUtil;
import com.utech.ap.Taxi_Project.Service.BookCab;
import com.utech.ap.Taxi_Project.Service.ChangeStatus;

public class MainView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
			//--- Unit Testing of Customer
		Customer customer3 = new Customer(691000, "Andre Sutherland");
		Customer customer4 = new Customer(691001, "Ray Stephens");
		CustomerDb customerdb = new CustomerDbImpl();
		customerdb.addCustomer(customer3);
		CustomerDb customerS = new CustomerDbImpl();
		customerS.addCustomer(customer4);
		
	
		/*
		//--- Unit Testing of Cab
		Cab cab1 = new Cab(12,"Aman Hooda");
		CabDb cabDao = new CabDbImpl();
		cabDao.addCab(cab1);
		
		
		Customer customer1 = new Customer(691736, "Andre Steele");
		Customer customer2 = new Customer(691740, "Ray Raymano");
		CustomerDb customerdb = new CustomerDbImpl();
		customerdb.addCustomer(customer1);
		CustomerDb customerS = new CustomerDbImpl();
		customerS.addCustomer(customer2);
		
	
		//----Booking
		
		BookCab bookCab = new BookCab();
		bookCab.bookCab(8, 691736);
		
		BookCab bookcab = new BookCab();
	       bookcab.bookCab(1, 691740);
	       
		
	        
	    
		   
			ChangeStatus changeStatus = new ChangeStatus();
			changeStatus.updateStatus(101, true);
		
			
		
		//--- Unit Testing of Cab
				Cab cab1 = new Cab(1,"Roger Angus");
				CabDb cabDao = new CabDbImpl();
				cabDao.addCab(cab1);
			
			*/
		
			BookingHelperDb bookinghelper = new BookingHelperDbImpl();
		System.out.println(bookinghelper.getBookingId());

			
			
	       
	        
		
	}

	}

