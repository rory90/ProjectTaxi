package com.utech.ap.Taxi_Project.Service.Customer;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.utech.ap.Taxi_Project.Entity.Booking;
import com.utech.ap.Taxi_Project.Entity.CardPayment;
import com.utech.ap.Taxi_Project.Entity.Search;
import com.utech.ap.Taxi_Project.Entity.Cab;
import com.utech.ap.Taxi_Project.Database.Customer.Customerdb;

@Component
public class CustomerService {

	@Autowired
	Customerdb da;

	public ArrayList<Object[]> search(Search search) throws ParseException{
		//System.out.println(searchbean.getSource());
		if(search.getSource()==null||search.getDestination()==null){
			return null;
		}
		else if(search.getSource().equals(search.getDestination())){
			return null;
		}
		else
		return da.search(search);
	}

	public ArrayList<ArrayList<String>> sourceDestination(){
		return da.sourceDestination();
	}

	public ArrayList<Object[]> giveroutedetails(Search searchbean){
		return da.giveroutedetails(searchbean);
	}
	public Cab getVehicle(String vid)
	{
		return da.getVehicle(vid);
	}
	public String checkCreditCardDetails(CardPayment card,HttpSession session)
	{
		return da.checkCreditCardDetails(card,session);
	}

	public String Cancellation (String bookingID,HttpSession session1)
	{
		return da.Cancellation(bookingID,session1);
	}
	public ArrayList<Booking>  bookinghistory(HttpSession session1)
	{
		return da.bookinghistory(session1);
	}
	 public Booking generateTicket(String bookingID)
	  {
	      return da.generateTicket(bookingID);
	  }
	 public ArrayList<Booking>  bookinghistorycustomers()

	 {
		 return da.bookinghistorycustomers();
	 }
}
