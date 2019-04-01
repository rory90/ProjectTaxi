package com.utech.ap.Taxi_Project.Service.Administrator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.utech.ap.Taxi_Project.Entity.Route;
import com.utech.ap.Taxi_Project.Database.Administrator.Routedb;

@Component 
public class RouteService {
	
	@Autowired
	Routedb da;
	public String addRoute(Route route){
		if(route==null)
			return "FAIL";
		else if(route.getRoute_id()==null){
			return "FAIL";
		}
			else
			{
				return da.addRoute(route);
			}
		}

	public Route ViewRoute(String route_id){

		return da.ViewRoute(route_id);
	}

	public String ModifyRoute(Route routebean){
		return da.ModifyRoute(routebean);

	}
	public String ConfirmDeleteRoute(Route routebean){

		return da.ConfirmDeleteRoute(routebean);
	}
	public List<Route> displayall()
	{
		return da.displayall();
	}

}
