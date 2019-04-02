package com.utech.ap.Taxi_Project.Controller.Administrator;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;

//import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;
import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.utech.ap.Taxi_Project.Entity.Route;
import com.utech.ap.Taxi_Project.Service.Administrator.RouteService;

@Controller
public class RouteController {

	@Autowired
	RouteService routeservice;
	@Autowired
	private DataFieldMaxValueIncrementer incrementer1;
	 @RequestMapping(value="/AddRoute",method = RequestMethod.GET)
	   public ModelAndView addRoute() {
		   ModelAndView model = new ModelAndView("AddRoute");
			return model;
	   }
	 @RequestMapping(value="/routemain",method = RequestMethod.POST)
	   public ModelAndView addRouteMain(Route route) {
		 if(route.getSource()==null||route.getSource().length()<2||route.getDestination()==null||route.getDestination().length()<2)
				 { ModelAndView model = new ModelAndView("AddRoute");
		 model.addObject("Warning", "Please enter valid source and destination of at least 2 characters");
		 return model;}
		 route.setRoute_id(route.getSource().substring(0,2)+route.getDestination().substring(0,2)+((Long)(incrementer1.nextLongValue())).toString());
		 if(routeservice.addRoute(route).equals("SUCCESS")){
			 ModelAndView model = new ModelAndView("Admin");
			 model.addObject("Warning", "Successfully Added");
				return model;
		 }
		 else if(routeservice.addRoute(route).equals("PRESENT")){

			 ModelAndView model = new ModelAndView("AddRoute");
			 model.addObject("Warning", "This combinaion of source and destination is already present");
			 return model;
		 }
		 else
		 {
			 ModelAndView model = new ModelAndView("AddRoute");
			 model.addObject("Warning", "Could not be added");
			 return model;
		 }

	   }

	 @RequestMapping(value="/ModifyRoute",method = RequestMethod.GET)
	   public ModelAndView ModifyRoute() {
		   ModelAndView model = new ModelAndView("ModifyRoute");
			return model;
	   }
	  @RequestMapping(value="/modifymainroute",method = RequestMethod.GET)
	   public ModelAndView modifymain(@RequestParam Map<String,String> map) {
		  System.out.println(map.get("route_id"));
		  if(routeservice.ViewRoute(map.get("route_id"))!=null)
		  {
			  ModelAndView model = new ModelAndView("ModifyRouteMain");
			  model.addObject("route", routeservice.ViewRoute(map.get("route_id")));
				return model;
		  }
		  else{
		   ModelAndView model = new ModelAndView("ModifyRoute");
		   model.addObject("warning", "route not present");
			return model;
			}
	   }
	  @RequestMapping(value="/FinalModifyRoute",method = RequestMethod.POST)
	  public ModelAndView FinalModifyRoute(Route route) {
		  if(routeservice.ModifyRoute(route).equals("SUCCESS"))
		  {
			  ModelAndView model = new ModelAndView("Admin");
				 model.addObject("Warning", "Successfully Modified");
					return model;
		  }
		  else
			  return null;

	  }


	  @RequestMapping(value="/DeleteRoute",method = RequestMethod.GET)
	   public ModelAndView deleteRoute() {
		   ModelAndView model = new ModelAndView("DeleteRoute");
			return model;
	   }


	  @RequestMapping(value="/deletemainroute",method = RequestMethod.GET)
	   public ModelAndView deletemain(@RequestParam Map<String,String> map) {
		  System.out.println(map.get("route_id"));
		  if(routeservice.ViewRoute(map.get("route_id"))!=null)
		  {
			  ModelAndView model = new ModelAndView("DeleteRouteMain");
			  model.addObject("route", routeservice.ViewRoute(map.get("route_id")));
				return model;
		  }
		  else{
		   ModelAndView model = new ModelAndView("DeleteRoute");
		   model.addObject("warning", "route number to be deleted not present");
			return model;
			}
	   }




	  @RequestMapping(value="/ConfirmDeleteRoute",method = RequestMethod.POST)
	   public ModelAndView ConfirmdeleteRoute(Route route) {
		  if(routeservice.ConfirmDeleteRoute(route).equals("SUCCESS"))
		   {
			  ModelAndView model = new ModelAndView("Admin");
				 model.addObject("Warning", "Successfully Deleted");
					return model;
		   }
		  else
			  return null;
		  }

	  @RequestMapping(value="/ViewAllRoute",method = RequestMethod.GET)
	  public ModelAndView viewAll()
	  {
		  ModelAndView model = new ModelAndView("Displayallroute");
		  List<Route> l=routeservice.displayall();
		  model.addObject("dlist", l);
			return model;
	  }
}
