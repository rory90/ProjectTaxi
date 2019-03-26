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
		Customer customer1 = new Customer(691736, "Andre Steele");
		Customer customer2 = new Customer(691740, "Ray Raymano");
		CustomerDb customerdb = new CustomerDbImpl();
		customerdb.addCustomer(customer1);
		
		
		//--- Unit Testing of Cab
		Cab cab1 = new Cab(103,"Aman Hooda");
		CabDb cabDao = new CabDbImpl();
		cabDao.addCab(cab1);
		
		
		//---- Unit Testing of Booking
		Booking book1 = new Booking();
		BookCab bookCab = new BookCab();
		bookCab.bookCab(8, 691736);
		
		
	        
	    
		
			ChangeStatus changeStatus = new ChangeStatus();
			changeStatus.updateStatus(101, true);
			changeStatus.updateStatus(102, true);
			changeStatus.updateStatus(103, true);
			
			
			
			BookingHelperDb bookinghelper = new BookingHelperDbImpl();
		System.out.println(bookinghelper.getBookingId());

			
		
	        BookCab bookcab = new BookCab();
	       
	        bookcab.bookCab(9, 691740);
	        bookcab.bookCab(4, 691743);
	        bookcab.bookCab(3, 691732);
	        

		
	}

	}

