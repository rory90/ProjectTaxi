<!--
Advanced Programming 
Rory Adamson   0903081
Travis Hibbert 1503333
Tutor: Gilroy Gordon 
-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 import="com.utech.ap.Taxi_Project.Entity.*" import="java.util.*"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display All</title>
</head>
<body bgcolor=CadetBlue>
<div style="text-align:center; padding:5px;background-color: Teal;">
<h1 align="center">Welcome to Hill Top Travel Agency</h1>
<h2 align="center">Details of All Vehicle Present</h2>
</div>
<% List<Cab> list=(List<Cab>)request.getAttribute("dlist"); %>


<table align="center" bgcolor="white" border="2">
<tr><td><b>Vehicle name</b></td><td><b>Vehicle Number</b></td><td><b>Seating Capacity</b></td>
<td><b>Vehicle Type</b></td><td><b>Fare Per KM</b></td></tr>
<%
for (Iterator iterator=list.iterator(); iterator.hasNext();)
{
	Cab vehicle=(Cab)iterator.next();%>
<tr><td><%=vehicle.getCabName() %></td><td><%=vehicle.getCabNumber() %></td><td><%=vehicle.getSeatingCapacity() %></td>
<td><%=vehicle.getVehicleType() %></td><td><%=vehicle.getFarePerKM() %></td></tr>
<% } %>
</table>

<a href="home">GO to home</a>
</body>
</html>
