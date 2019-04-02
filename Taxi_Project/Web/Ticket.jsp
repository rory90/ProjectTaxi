<!--
Advanced Programming 
Rory Adamson 	0903081
Travis Hibbert 	1503332
Tutor: Gilroy Gordon 
-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.utech.ap.Taxi_Project.Entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Ticket </title>
</head>
<body bgcolor=CadetBlue >
<div style="text-align:center; padding:5px;background-color: Teal;">
<h1 align="center">Welcome <%=session.getAttribute("loginid") %></h1>
<h1 align="center">Welcome to Hill Top Travel Agency </h1>
</div>
<%Booking booking=(Booking)request.getAttribute("ticket"); %>
<table align="center" border="2">
<tr><td>Booking id</td><td><%=booking.getBookingid() %></td></tr>
<tr><td>Vehicle Number</td><td><%=booking.getVehicleNumber() %></td></tr>
<tr><td>Booking date</td><td><%=booking.getBookingDate() %></td></tr>
<tr><td>Journey date</td><td><%=booking.getJourneyDate() %></td></tr>
<tr><td>Fare</td><td><%=booking.getFare() %></td></tr>
<tr><td><a href="customerhome">Print Ticket</a></td></tr>
</table>
</body>
</html>