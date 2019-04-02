<!--
Advanced Programming 
Rory Adamson   0903081
Travis Hibbert 1503333
Tutor: Gilroy Gordon 
-->



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*" import="com.utech.ap.Taxi_Project.Entity.Booking"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking History</title>
</head>
<body bgcolor=CadetBlue >
<div style="text-align:center; padding:5px;background-color: Teal;">
<h1 align="center">Welcome <%=session.getAttribute("loginid") %></h1>
<h1 align="center">Welcome to Hill Top Travel Agency </h1>
</div>
<h1 align="center"> Booked Ticket Details </h1>
<%  ArrayList<Booking> booking = (ArrayList<Booking>)request.getAttribute("booking");
System.out.println(booking);%>
<table align="center" bgcolor="white">
<tr><td><b>BookingID</b></td><td><b>Vehicle Number</b></td>
<td><b>JourneyDate</b></td><td><b>BookingDate</b></td> <td><b>Fare</b></td></tr>
<%
for (Iterator iterator=booking.iterator(); iterator.hasNext();)
{
	Booking booking2=(Booking)iterator.next();%>
<tr><td><%=booking2.getBookingid() %></td><td><%=booking2.getVehicleNumber() %></td><td><%=booking2.getJourneyDate().toString().substring(0, 11) %></td>
<td><%=booking2.getBookingDate().toString().substring(0, 11) %></td><td><%=booking2.getFare() %></td></tr>
<% } %>
</table>

</body>
</html>
