<!--
Advanced Programming 
Rory Adamson   0903081
Travis Hibbert 1503333
Tutor: Gilroy Gordon 
-->


<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import = "com.utech.ap.Taxi_Project.Entity.*"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Driver Main</title>
</head>
<body bgcolor=CadetBlue>
<div style="text-align:center; padding:5px;background-color: Teal;">
<h1 align="center">Welcome to Hill Top Travel Agency</h1>
<h2 align="center">please add Driver details</h2>
</div>
<h3 align="center" style="color: red;">${warning}</h3>

<% Object array[] = new Object[2];
	array = (Object[])request.getAttribute("returning_array");
	Driver driver = (Driver) array[0];
	DriverAddress da = (DriverAddress) array[1];

%>

<form  action="finaldeletedriver" METHOD=POST>
<table align="center">

<tr><td>Cab Number</td><td><input type="text" name=CabNumber readonly="readonly" value=<%=driver.getCabNumber() %>></td></tr>
<tr><td>First Name</td><td><input type="text" name=firstName readonly="readonly" value=<%=driver.getFirstName() %> ></td></tr>
<tr><td>Last Name</td><td><input type="text" name="lastName" readonly="readonly" value=<%=driver.getLastName() %>></tr>
<tr><td>License Number</td><td><input type="text" name=licenseNumber readonly="readonly" value=<%=driver.getLicenseNumber() %>></td></tr>
<tr><td>Contact Number</td><td><input type="text" name=contactNumber value=<%=driver.getContactNumber() %>></td></tr>

<tr><td></td><td><input type="hidden" name=driverid readonly="readonly" value=<%=da.getDriverid() %>></td></tr>
<tr><td>House Number</td><td><input type="text" name=houseNumber value=<%=da.getHouseNumber() %>></td></tr>
<tr><td>First Line Of Address</td><td><input type="text" name="firstLineOfAddress" value=<%=da.getFirstLineOfAddress() %>></tr>
<tr><td>Second Line Of Address</td><td><input type="text" name=secondLineOfAddress value=<%=da.getSecondLineOfAddress() %> ></td></tr>
<tr><td>City</td><td><input type="text" name=city value=<%=da.getCity() %>></td></tr>
<tr><td>Parish</td><td><input type="text" name=parish value=<%=da.getState() %>></td></tr>
<tr><td>Pin Code</td><td><input type="text" name=pinCode value=<%=da.getPinCode() %>></td></tr>
<tr><td></td><td><input type="submit" value="Confirm Delete Driver"></td></tr>
</table>
</form>
<a href="home">GO to home</a>
</body>
</html>
