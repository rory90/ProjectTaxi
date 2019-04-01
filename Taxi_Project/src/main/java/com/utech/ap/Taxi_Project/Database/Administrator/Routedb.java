package com.utech.ap.Taxi_Project.Database.Administrator;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.utech.ap.Taxi_Project.Entity.Route;

@Component
public class Routedb {

	
	@Autowired
	SessionFactory sessionFactory;
		public String addRoute(Route routebean){
			 Session session=sessionFactory.openSession();
			    Transaction trx=null;
			    trx=session.beginTransaction();
			    Query query = session.createSQLQuery("select * from ata_tbl_route where source = ? and destination = ?");

			    query.setString(0, routebean.getSource());
			    query.setString(1, routebean.getDestination());
			    ArrayList<Object> sameroutecheck = (ArrayList<Object>) query.list();

			    if(sameroutecheck.size()>0){
			    	System.out.println(sameroutecheck);
			    	return "PRESENT";
			    }

			   try{
				   session.save(routebean);
				   trx.commit();
				   session.close();

				   return "SUCCESS";
			   }
			   catch(Exception e)
			   {
				   System.out.println(e);
				   return "FAIL";
			   }
		}
		public Route ViewRoute(String routenumber){
			Session session=sessionFactory.openSession();
		    Transaction trx=null;
		    trx=session.beginTransaction();
		    try{
		    return (Route)session.get(Route.class, routenumber);
		    }catch(Exception e)
		    {
		    	return null;
		    }

		}
		public String ModifyRoute(Route routebean){

			Session session=sessionFactory.openSession();
		    Transaction trx=null;
		    trx=session.beginTransaction();
		    session.saveOrUpdate(routebean);
		    trx.commit();
			   session.close();

			   return "SUCCESS";
			}
		public String ConfirmDeleteRoute(Route routebean){
			Session session=sessionFactory.openSession();
		    Transaction trx=null;
		    trx=session.beginTransaction();
		    session.delete(routebean);
		    trx.commit();
			   session.close();
			   return "SUCCESS";
		}
		public List<Route> displayall()
		{
		    Session session=sessionFactory.openSession();
		    Transaction trx=null;
		    trx=session.beginTransaction();
		    Query query=session.createQuery("from ata_tbl_route");
		    List<Route> routes= query.list();
			return routes;
		}
}
