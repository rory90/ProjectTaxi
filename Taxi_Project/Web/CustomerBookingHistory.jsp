<!--
Advanced Programming 
Rory Adamson   0903081
Travis Hibbert 1503333
Tutor: Gilroy Gordon 
-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*" import="com.utech.ap.Taxi_Project.Entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Booking History</title>
</head>
<body bgcolor=CadetBlue >
<div style="text-align:center; padding:5px;background-color: Teal;">
<h1 align="center">Welcome Administration</h1>
<h1 align="center">Welcome to Hill Top Travel Agency </h1>
</div>
<h1 align="center"> All Booked Ticket Details </h1>
<%  ArrayList<Booking> bookingbeans= (ArrayList<Booking>)request.getAttribute("booking");
%>
<table align="center" bgcolor="white" border="2">
<tr><td><b>LoginID</b></td><td><b>BookingID</b></td><td><b>Cab Number</b></td>
<td><b>JourneyDate</b></td><td><b>BookingDate</b></td> <td><b>Fare</b></td></tr>
<%
for (Iterator iterator=bookingbeans.iterator(); iterator.hasNext();)
{
	Booking booking=(Booking)iterator.next();%>
<tr><td><%=booking.getLoginid() %></td><td><%=booking.getBookingid() %></td><td><%=booking.getVehicleNumber() %></td><td><%=booking.getJourneyDate().toString().substring(0, 11) %></td>
<td><%=booking.getBookingDate().toString().substring(0, 11) %></td><td><%=booking.getFare() %></td></tr>
<% } %>
</table>
<a href="home">go to home</a>
</body>
</html>
