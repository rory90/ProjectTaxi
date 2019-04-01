package com.utech.ap.Taxi_Project.Controller.Administrator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.utech.ap.Taxi_Project.Entity.Driver;
import com.utech.ap.Taxi_Project.Entity.DriverAddress;
import com.utech.ap.Taxi_Project.Entity.Cab;
import com.utech.ap.Taxi_Project.Service.Administrator.DriverService;

public class DriverController {
	
	@Autowired
	private DataFieldMaxValueIncrementer incrementer;
	@Autowired
	DriverService driverservice;

	@RequestMapping(value="/AddDriver",method = RequestMethod.GET)
	   public ModelAndView AddDriver() {
		   ModelAndView model = new ModelAndView("AddDriver");
			return model;
	   }
	@RequestMapping(value="/drivermain",method = RequestMethod.POST)
	   public ModelAndView drivermain(@RequestParam Map<String,String> map) {
		String id;
		Driver driver = new Driver();
		Long identifier = incrementer.nextLongValue();
		try{
			id  = map.get("firstName").substring(0, 2)+identifier.toString().trim();
		}catch(Exception e){
			 ModelAndView model = new ModelAndView("AddDriver");
			 model.addObject("warning", "First Name must contain more than two characters");
				return model;
		}
		driver.setDriverid(id);
		driver.setFirstName(map.get("firstName"));
		driver.setLastName(map.get("lastName"));
		driver.setLicenseNumber(map.get("licenseNumber"));
		driver.setCabNumber(map.get("CabNumber"));
		driver.setContactNumber(map.get("contactNumber"));

		DriverAddress dabean = new DriverAddress();
		dabean.setDriverid(id);
		dabean.setCity(map.get("city"));
		dabean.setFirstLineOfAddress(map.get("firstLineOfAddress"));
		dabean.setSecondLineOfAddress(map.get("secondLineOfAddress"));
		try
		{
			dabean.setHouseNumber(Integer.parseInt(map.get("houseNumber")));
		}catch(Exception e){
			 ModelAndView model = new ModelAndView("AddDriver");
			 model.addObject("warning", "House Number should be Integer");
				return model;
		}
		dabean.setPinCode(map.get("pinCode"));
		dabean.setState(map.get("state"));
		System.out.println(map.get("state"));
		String result=driverservice.addDriver(driver, dabean);
		System.out.println(result);
		if(result.equals("FAIL")){
			ModelAndView model = new ModelAndView("AddDriver");
			 model.addObject("warning", "Please Provide Complete Information");
				return model;
		}
		else if(result.equals("ERROR")){
			ModelAndView model = new ModelAndView("AddDriver");
			 model.addObject("warning", "Vehicle number given by u is not present");
				return model;
		}



		else{
			ModelAndView model = new ModelAndView("Admin");
			 model.addObject("message", "Driver Details Successfully Added");
				return model;
		}


	   }
	@RequestMapping(value="/ModifyDriver",method = RequestMethod.GET)
	   public ModelAndView ModifyDriver() {
		   ModelAndView model = new ModelAndView("ModifyDriver");
			return model;
	   }
	@RequestMapping(value="/modifymaindriver",method = RequestMethod.POST)
	   public ModelAndView modifymain(@RequestParam Map<String,String> map) {
		Object array[] = new Object[2];
		array = driverservice.viewDriver(map.get("vehicleNumber"));
		if(array == null){
			ModelAndView model = new ModelAndView("ModifyDriver");
			model.addObject("warning", "This Vehicle is not present");
			return model;
		}
		else{
			ModelAndView model = new ModelAndView("ModifyDriverMain");
			model.addObject("returning_array", array);
			return model;
		}

	   }


	@RequestMapping(value="/finalmodifydriver",method = RequestMethod.POST)
	   public ModelAndView finalmodifydriver(@RequestParam Map<String,String> map) {

		Driver driver = new Driver();

		driver.setFirstName(map.get("firstName"));
		driver.setLastName(map.get("lastName"));
		driver.setLicenseNumber(map.get("licenseNumber"));
		driver.setCabNumber(map.get("vehicleNumber"));
		driver.setContactNumber(map.get("contactNumber"));
		driver.setDriverid(map.get("driverid"));
		DriverAddress da = new DriverAddress();
		da.setCity(map.get("city"));
		da.setFirstLineOfAddress(map.get("firstLineOfAddress"));
		da.setSecondLineOfAddress(map.get("secondLineOfAddress"));
		da.setDriverid(map.get("driverid"));
		try
		{
			da.setHouseNumber(Integer.parseInt(map.get("houseNumber")));
		}catch(Exception e){
			 ModelAndView model = new ModelAndView("ModifyDriverMain");
			 model.addObject("warning", "House Number should be Integer");
				return model;
		}
		da.setPinCode(map.get("pinCode"));
		da.setState(map.get("state"));

		if(driverservice.modifyDriver(driver, da).equals("SUCCESS")){
			ModelAndView model = new ModelAndView("Admin");
			 model.addObject("Warning", "Information successfully updated");
				return model;
		}
		return null;


	}
	@RequestMapping(value="/DeleteDriver",method = RequestMethod.GET)
	   public ModelAndView DeleteDriver() {
		   ModelAndView model = new ModelAndView("DeleteDriver");
			return model;
	   }
	@RequestMapping(value="/deletemaindriver",method = RequestMethod.POST)
	   public ModelAndView deletemain(@RequestParam Map<String,String> map) {
		Object array[] = new Object[2];
		array = driverservice.viewDriver(map.get("vehicleNumber"));
		if(array == null){
			ModelAndView model = new ModelAndView("DeleteDriver");
			model.addObject("warning", "This Vehicle is not present");
			return model;
		}
		else{
			ModelAndView model = new ModelAndView("DeleteDriverMain");
			model.addObject("returning_array", array);
			return model;
		}

	   }




	@RequestMapping(value="/finaldeletedriver",method = RequestMethod.POST)
	   public ModelAndView finaldeletedriver(@RequestParam Map<String,String> map) {

		Driver driverbean = new Driver();

		driverbean.setFirstName(map.get("firstName"));
		driverbean.setLastName(map.get("lastName"));
		driverbean.setLicenseNumber(map.get("licenseNumber"));
		driverbean.setCabNumber(map.get("vehicleNumber"));
		driverbean.setContactNumber(map.get("contactNumber"));
		driverbean.setDriverid(map.get("driverid"));
		DriverAddress dabean = new DriverAddress();
		dabean.setCity(map.get("city"));
		dabean.setFirstLineOfAddress(map.get("firstLineOfAddress"));
		dabean.setSecondLineOfAddress(map.get("secondLineOfAddress"));
		dabean.setDriverid(map.get("driverid"));
		try
		{
			dabean.setHouseNumber(Integer.parseInt(map.get("houseNumber")));
		}catch(Exception e){
			 ModelAndView model = new ModelAndView("ModifyDriverMain");
			 model.addObject("warning", "House Number should be Integer");
				return model;
		}
		dabean.setPinCode(map.get("pinCode"));
		dabean.setState(map.get("state"));

		if(driverservice.deleteDriver(driverbean, dabean).equals("SUCCESS")){
			ModelAndView model = new ModelAndView("Admin");
			 model.addObject("Warning", "Information successfully Deleted");
				return model;
		}
		return null;



	}

	@RequestMapping(value="/ViewAllDriver",method = RequestMethod.GET)
	  public ModelAndView viewAll()
	  {
		ArrayList<Object[]> arraydriver = new ArrayList<Object[]>();
		  ModelAndView model = new ModelAndView("DisplayAllDriver");
		 arraydriver = driverservice.displayall();
		  model.addObject("drivers", arraydriver);
		 Iterator it = arraydriver.iterator();
		 while(it.hasNext()){
			 Object[] arraydriverinfo = (Object[]) it.next();
			// System.out.print(arraydriverinfo[0]+"  "+arraydriverinfo[1]+" "+arraydriverinfo[11]);
		 }

			return model;
	  }


}
