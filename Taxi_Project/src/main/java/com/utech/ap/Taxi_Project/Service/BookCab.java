package com.utech.ap.Taxi_Project.Service;

import com.utech.ap.Taxi_Project.Database.BookingDb;
import com.utech.ap.Taxi_Project.Database.BookingDbImpl;
import com.utech.ap.Taxi_Project.Database.BookingHelperDb;
import com.utech.ap.Taxi_Project.Database.BookingHelperDbImpl;
import com.utech.ap.Taxi_Project.Database.CabDb;
import com.utech.ap.Taxi_Project.Database.CabDbImpl;
import com.utech.ap.Taxi_Project.Database.CustomerDb;
import com.utech.ap.Taxi_Project.Database.CustomerDbImpl;
import com.utech.ap.Taxi_Project.Entity.Booking;



public class BookCab {
	

	public void bookCab(int distance, int customerId){
		
		BookingHelperDb bookinghelperdb = new BookingHelperDbImpl();	
		CabDb cabdb = new CabDbImpl();
		int cabId = cabdb.getCabId();
	
	
	if(cabId!=0) {
		
		Booking book = new Booking();
		bookinghelperdb.setBookingId(); //incrementing ID indb
		book.setBookingId(bookinghelperdb.getBookingId());//fetching id from db
		
		book.setDistance(distance);
		book.setCustomerId(customerId);
		
		book.setCabId(cabId);
		
		if(distance>10) {book.setBillingAmount(305 + (distance-10)*25);}
		else if (distance <10 & distance>5) {
			
			book.setBillingAmount(180 + (distance-5)*25);
		}
		else if (distance <5 & distance>1) {
			
			book.setBillingAmount(100 + (distance-1)*20);
		}
		else 	book.setBillingAmount(100);
		
		// invoke db methods
		//update booking details to the db
		BookingDb bookingdb = new BookingDbImpl();
		bookingdb.addBooking(book);
		
		// change status of that cab 
		ChangeStatus changeStatus = new ChangeStatus();

		changeStatus.updateStatus(book.getCabId(),false);

	
	}else
	{System.out.println("Booking is not confirmed, Since no cabs are available at the moment.");}
	
	
	
	
	
}
	
	


	
	
}
