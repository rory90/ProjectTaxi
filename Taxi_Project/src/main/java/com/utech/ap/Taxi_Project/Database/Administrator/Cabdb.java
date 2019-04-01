package com.utech.ap.Taxi_Project.Database.Administrator;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.utech.ap.Taxi_Project.Entity.Cab;


@Component
public class Cabdb {
	
	@Autowired
	SessionFactory sessionFactory;
		public String addVehicle(Cab vehicle){
			 Session session=sessionFactory.openSession();
			    Transaction trx=null;
			    trx=session.beginTransaction();
			   try{
				   session.save(vehicle);
				   trx.commit();
				   session.close();
				   return "SUCCESS";
			   }
			   catch(Exception e){
				   return "FAIL";
			   }
		}

		public Cab ViewVehicle(String cabnumber){
			Session session=sessionFactory.openSession();
		    Transaction trx=null;
		    trx=session.beginTransaction();
		    try{
		    return (Cab)session.get(Cab.class, cabnumber);
		    }catch(Exception e)
		    {
		    	return null;
		    }

		}

	public String ModifyVehicle(Cab vehicle){

		Session session=sessionFactory.openSession();
	    Transaction trx=null;
	    trx=session.beginTransaction();
	    session.saveOrUpdate(vehicle);
	    trx.commit();
		   session.close();
		   return "SUCCESS";
		}

	public String ConfirmDeleteVehicle(Cab vehicle){
		Session session=sessionFactory.openSession();
	    Transaction trx=null;
	    trx=session.beginTransaction();
	    session.delete(vehicle);
	    trx.commit();
		   session.close();
		   return "SUCCESS";
	}


	public List<Cab> displayall()
	{
	    Session session=sessionFactory.openSession();
	    Transaction trx=null;
	    trx=session.beginTransaction();
	    Query query=session.createQuery("from ata_tbl_vehicle");
	    List<Cab> vehicles= query.list();
		return vehicles;
	}

}
