package com.utech.ap.Taxi_Project.Database.Login;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.utech.ap.Taxi_Project.Entity.Login;
import com.utech.ap.Taxi_Project.Entity.UserProfile;

public class LoginDb {
	
	@Autowired
	private SessionFactory sessionFactory;

	public boolean validateUser(Login login1) {
		Login login;
		 Session session=sessionFactory.openSession();
		    Transaction trx=null;
		    trx=session.beginTransaction();
		    System.out.println(login1.getLogin_id());
		 try{
			 login=(Login) session.get(Login.class,login1.getLogin_id());

		 }catch(Exception e)
	 	  {return false;}


		 if(login==null)
		return false;
		    else
		    {
		    	if(login.getPassword().equals(login.getPassword()))
		    		return true;
		    	else
		    		return false;
		    }


	}


	
	public String getUserType(Login login) {
		 Session session=sessionFactory.openSession();
		    Transaction trx=null;
		    trx=session.beginTransaction();
		    Login login2=(Login) session.get(Login.class,login.getLogin_id());
		return login2.getUser_type();
	}

	public String checkUser(Login loginbean){
		Login login;
		 Session session=sessionFactory.openSession();
		    Transaction trx=null;
		    trx=session.beginTransaction();
		    login=(Login) session.get(Login.class,loginbean.getLogin_id());
		    if(login==null)
		    	return "NOT_PRESENT";
		    else
		    	return "PRESENT";

	}

	public String addNewUser(Login login){
		Session session=sessionFactory.openSession();
	    Transaction trx=null;
	    trx=session.beginTransaction();
	    session.save(login);
	    trx.commit();
	    session.close();
	    return "SUCCESS";
	}
	
	public String addNewUser(UserProfile up){
		Session session=sessionFactory.openSession();
	    Transaction trx=null;
	    trx=session.beginTransaction();
	    session.save(up);
	    trx.commit();
	    session.close();
	    return "SUCCESS";
	}


}
