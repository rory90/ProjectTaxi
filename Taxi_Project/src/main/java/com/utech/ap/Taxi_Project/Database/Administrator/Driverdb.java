package com.utech.ap.Taxi_Project.Database.Administrator;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.utech.ap.Taxi_Project.Entity.DriverAddress;
import com.utech.ap.Taxi_Project.Entity.Driver;
import com.utech.ap.Taxi_Project.Entity.Cab;

@Component
public class Driverdb {
	
	@Autowired
	SessionFactory sessionFactory;
		public String addDriver(Driver driverbean, DriverAddress da){
			Transaction trx=null;
			Session session;
			 try{
			 session=sessionFactory.openSession();
			 trx=session.beginTransaction();
			    session.save(driverbean);
			    session.save(da);
			    trx.commit();
			    session.close();
			    }catch(Exception e)
			    {
			    	System.out.println(e);
			    	return "ERROR";
			    }

			    return "SUCCESS";
}
		public Object[] viewDriver(String cabNumber){
			Object[] array = new Object[2];
			Transaction trx=null;
			Session session=sessionFactory.openSession();
			 trx=session.beginTransaction();
			 Driver driver = (Driver) session.get(Driver.class, cabNumber);
			 if(driver==null){
				 return null;
			 }
			 else{
				 String id = driver.getDriverid();
				 DriverAddress da = (DriverAddress) session.get(DriverAddress.class, id);
				 array[0] = driver;
				 array[1] = da;
				 return array;
			 }
		}
		public String modifyDriver(Driver driver, DriverAddress da){
			Transaction trx=null;
			Session session=sessionFactory.openSession();
			 trx=session.beginTransaction();
			 System.out.println(driver.getDriverid());
			 System.out.println(driver.getCabNumber());
			 System.out.println(da.getDriverid());
			 session.saveOrUpdate(driver);
			 session.saveOrUpdate(da);
			 trx.commit();
			 session.close();
			 return "SUCCESS";
		}

		public String deleteDriver(Driver driver, DriverAddress da){
			Transaction trx=null;
			Session session=sessionFactory.openSession();
			 trx=session.beginTransaction();
			 session.delete(driver);
			 session.delete(da);
			 trx.commit();
			 session.close();
			 return "SUCCESS";
		}
		/*public Object[] viewDriver(){
			Session session=sessionFactory.openSession();
		    Transaction trx=null;
		    trx=session.beginTransaction();
		    Query query=session.createQuery("from ata_tbl_driver");
		    List<DriverBean> drivers= query.list();

		    Query queryAddress=session.createQuery("from ata_tbl_driver_address");
		    List<DriverAddressBean> driverAddress= query.list();
			return ;
		}*/
		public ArrayList<Object[]> displayall()
		{

			Object[] arraydriver = new Object[12];
		    Session session=sessionFactory.openSession();
		    Transaction trx=null;
		    trx=session.beginTransaction();
		    //Query query=session.createQuery("from DriverBean natural join DriverAddressBean");
		    //ArrayList<Object[]> listdriver = (ArrayList<Object[]>) query.list();
		    Query query= session.createSQLQuery("select * from ata_tbl_driver natural join ata_tbl_driver_address ");
		    ArrayList<Object[]> listdriver = (ArrayList<Object[]>) query.list();
		   return listdriver;


		}


	
}
