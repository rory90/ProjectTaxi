package com.utech.ap.Taxi_Project.Database.Customer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.utech.ap.Taxi_Project.Entity.Cab;
import com.utech.ap.Taxi_Project.Entity.Search;
import com.utech.ap.Taxi_Project.Entity.Booking;
import com.utech.ap.Taxi_Project.Entity.CardPayment;
import com.utech.ap.Taxi_Project.Entity.PaymentHistory;

@Component
public class Customerdb {
	
	@Autowired
	SessionFactory sessionFactory;

	public ArrayList<Object[]> search(Search search) throws ParseException{

			 Session session=sessionFactory.openSession();
			    Transaction trx=null;
			    trx=session.beginTransaction();
			    DateFormat formatter ;
				  Date date;
				  formatter = new SimpleDateFormat("dd/MM/YYYY");
				  ArrayList<Object[]> vehicles;
				  if(!(search.getVehicleType().isEmpty())&&!(search.getCabName().isEmpty())){
			 Query query = session.createSQLQuery("select * from ata_tbl_vehicle where vehicle_number not in(select vehicle_number from ata_tbl_booking where journey_date=?) and vehicle_type=? and vehicle_name=?");
				  query.setDate(0, formatter.parse(search.getJourneyDate()));
				  query.setString(1, search.getVehicleType());
				  query.setString(2, search.getCabName());
				//  System.out.println(searchbean.getVehicleType()+"   "+searchbean.getVehicleName());

				//  System.out.println("both not null");
				  vehicles= (ArrayList<Object[]>) query.list();
				  }

				  else if(search.getVehicleType().isEmpty() && search.getCabName().isEmpty()){
					  Query query = session.createSQLQuery("select * from ata_tbl_vehicle where vehicle_number not in(select vehicle_number from ata_tbl_booking where journey_date=?)");
					  query.setDate(0, formatter.parse(search.getJourneyDate()));
					 // System.out.println("both null");
				vehicles= (ArrayList<Object[]>) query.list();
				  }

				  else if(search.getVehicleType().isEmpty()){
					  Query query = session.createSQLQuery("select * from ata_tbl_vehicle where vehicle_number not in(select vehicle_number from ata_tbl_booking where journey_date=?) and vehicle_name=?");
					  query.setDate(0, formatter.parse(search.getJourneyDate()));
					 // System.out.println("name not null");
					  query.setString(1, search.getCabName());

					  vehicles= (ArrayList<Object[]>) query.list();
				  }
				  else{
					  Query query = session.createSQLQuery("select * from ata_tbl_vehicle where vehicle_number not in(select vehicle_number from ata_tbl_booking where journey_date=?) and vehicle_type=?");
					  query.setDate(0, formatter.parse(search.getJourneyDate()));
					  query.setString(1, search.getVehicleType());
					 // System.out.println("type not null");
					  vehicles= (ArrayList<Object[]>) query.list();
				  }

				   trx.commit();
				   session.close();
				   return vehicles;
	}

	public ArrayList<ArrayList<String>> sourceDestination(){
		Session session=sessionFactory.openSession();
	    Transaction trx=null;
	    trx=session.beginTransaction();
	    Query querysource = session.createSQLQuery("select source from ata_tbl_route");
	    ArrayList<String> sources = (ArrayList<String>) querysource.list();

	    Query querydestination = session.createSQLQuery("select destination from ata_tbl_route");
	    ArrayList<String> destinations = (ArrayList<String>) querydestination.list();
	    ArrayList<ArrayList<String>> sourceDestination = new ArrayList<ArrayList<String>>();
	    sourceDestination.add(sources);
	    sourceDestination.add(destinations);

	    return sourceDestination;

	}

	public ArrayList<Object[]> giveroutedetails(Search search){
		Session session=sessionFactory.openSession();
	    Transaction trx=null;
	    trx=session.beginTransaction();
	    System.out.println("source"+search.getSource());
	    System.out.println("dest"+search.getDestination());

	    Query query = session.createSQLQuery("select distance,route_id from ata_tbl_route where source=? and destination=?");
	    query.setString(0,search.getSource());
	    query.setString(1,search.getDestination());
	    ArrayList<Object[]> routedetails = (ArrayList<Object[]>) query.list();
	    trx.commit();
		session.close();
	    return routedetails;

	}
	public Cab getVehicle(String vid)
	{
		Session session=sessionFactory.openSession();
	    Transaction trx=null;
	    trx=session.beginTransaction();
	    Cab vehicle =(Cab)session.get(Cab.class,vid);
	    return vehicle;

	}
	public String checkCreditCardDetails(CardPayment card,HttpSession session1)
	{
		Session session=sessionFactory.openSession();
	    Transaction trx=null;
	    trx=session.beginTransaction();

	    CardPayment creditcardBean=(CardPayment)session.get(CardPayment.class,card.getCardNumber());
	    if(creditcardBean==null)
	    {
	    	System.out.println("null object");
	    	return "FAIL";
	    }
	    else if(creditcardBean.getValidFrom().equals(card.getValidFrom()) && creditcardBean.getValidTo().equals(card.getValidTo()))
	    {

	    	Booking bookingbean=(Booking) session1.getAttribute("bookingbean");
	    	session.save(bookingbean);
	    	System.out.println(bookingbean.getBookingid());
	    	PaymentHistory history=new PaymentHistory();
	    	history.setBookingId(bookingbean.getBookingid());
	    	history.setCardNumber(card.getCardNumber());
	    	history.setModeOfPayment("credit card");
	    	history.setTotalFare(bookingbean.getFare());
	    	session.save(history);
	    	trx.commit();
			session.close();
	    	return "SUCCESS";

	    }
	    else
	    {
            //System.out.println(creditcardBean.getValidFrom());
           // System.out.println(creditcardbean.getValidFrom());
	    	//System.out.println("date doesn't matches");
	    	return "FAIL";
	    }



	}

	public String Cancellation (String bookingID,HttpSession session1)
	{
		Session session=sessionFactory.openSession();
	    Transaction trx=null;
	    trx=session.beginTransaction();
	    Booking booking =(Booking)session.get(Booking.class, bookingID);
	    if(booking==null)
	    	return "FAIL";
	    else
	    {

	    	PaymentHistory history=(PaymentHistory) session.get(PaymentHistory.class,bookingID);
	    	session1.setAttribute("history",history);
	    	session.delete(history);
	    	session.delete(booking);
	    	trx.commit();
			session.close();
	    	return "SUCCESS";

	    }

	}
	public ArrayList<Booking>  bookinghistory(HttpSession session1)
	{
		Session session=sessionFactory.openSession();
	    Transaction trx=null;
	    trx=session.beginTransaction();
	    String loginid=(String) session1.getAttribute("loginid");
	    Query query = session.createQuery("from ata_tbl_booking where login_id=?");
	    query.setString(0,loginid);

	    ArrayList<Booking> bookingbeans = (ArrayList <Booking>)query.list();
	    return bookingbeans;


	}
	  public Booking generateTicket(String bookingID)
	  {
		  Session session=sessionFactory.openSession();
		    Transaction trx=null;
		    trx=session.beginTransaction();
		    Booking booking=(Booking)session.get(Booking.class, bookingID);
		    return booking;
	  }
	  public ArrayList<Booking>  bookinghistorycustomers()
		{
			Session session=sessionFactory.openSession();
		    Transaction trx=null;
		    trx=session.beginTransaction();

		    Query query = session.createQuery("from ata_tbl_booking");


		    ArrayList<Booking> bookingbeans = (ArrayList <Booking>)query.list();
		    return bookingbeans;


		}
	
	

}
