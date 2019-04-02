package com.utech.ap.Taxi_Project.Service.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.utech.ap.Taxi_Project.Entity.Login;
import com.utech.ap.Taxi_Project.Entity.UserProfile;
import com.utech.ap.Taxi_Project.Database.Login.LoginDb;


@Component
public class LoginService {
	
	  @Autowired
		private LoginDb db;
	  
		public String login(Login da) {
			boolean b;
			String temp;
			if(da==null)
				return "INVALID";
			else if(da.getLogin_id()==null || da.getPassword()==null)
				return "INVALID";
			else
				b=db.validateUser(da);

			if(b==false)
				return "INVALID";
			else
				{
				temp=db.getUserType(da);
			   return temp;
			}

		}

		public String addNewUser(Login login){
			String result = db.checkUser(login);
			if(result.equals("NOT_PRESENT"))
			{
				return db.addNewUser(login);

			}
			else
				return "PRESENT";
		}
		public String addNewUser(UserProfile up){
			return db.addNewUser(up);
		}

}
