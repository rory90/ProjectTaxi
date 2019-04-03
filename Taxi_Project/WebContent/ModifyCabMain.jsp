<!--
Advanced Programming 
Rory Adamson 	0903081
Travis Hibbert 	1503332
Tutor: Gilroy Gordon 
-->


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   import="com.utech.ap.Taxi_Project.Entity.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modify Vehicle Main</title>
</head>
<body bgcolor=CadetBlue>
<div style="text-align:center; padding:5px;background-color: Teal;">
<h1 align="center">Welcome to Travel Agency</h1>
<h2 align="center">please modify vehicle details</h2>
</div>
<h3 align="center" style="color: red;">${Warning}</h3>
<form  action="FinalModifyVehicle" METHOD=POST>
<% Cab vehicle=(Cab)request.getAttribute("vehicle");
  boolean b;
  if(vehicle.getVehicleType().equals("AC"))
	  b=true;
  else
	  b=false;

  System.out.println("in the vehicle "+vehicle.getCabNumber());

%>
<table align="center">
<tr><td>Cab Number</td><td><input type="text" name=CabNumber value=<%=vehicle.getCabNumber() %> readonly="readonly"></td></tr>
<tr><td>Cab Name</td><td><input type="text" name=CabName value=<%=vehicle.getCabName() %>></td></tr>
<tr><td>Seating Capacity</td><td><input type="text" name=seatingCapacity value=<%=vehicle.getSeatingCapacity() %>></td></tr>
<tr><td>Vehicle Type</td><td><input type="radio" name="vehicleType" checked=<%=b %> value="AC">AC<br>
                       <input type="radio" name="vehicleType" checked=<%=b %> value="Non-AC">Non-AC</td></tr>
<tr><td>Fare Per KM</td><td><input type="text" name=farePerKM value=<%=vehicle.getFarePerKM() %>></td></tr>
<tr><td></td><td><input type="submit" value="Modify Vehicle"></td></tr>
</table>
</form>
<a href="home">GO to home</a>
</body>
</html>