<!--
Advanced Programming 
Rory Adamson 	0903081
Travis Hibbert 	1503332
Tutor: Gilroy Gordon 
-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 import="com.utech.ap.Taxi_Project.Entity.*" import="java.util.*"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Search Results </title>
</head>
<body bgcolor=CadetBlue>
<div style="text-align:center; padding:5px;background-color: Teal;">
<h1 align="center">Welcome to Hill Top Travel Agency</h1>
<h2 align="center">Details of All Vehicle Present</h2>
</div>
<% ArrayList<Object[]> list=(ArrayList<Object[]>)request.getAttribute("dlist");
//System.out.println("hitrg"+list);
/* SearchBean searchbean=(SearchBean)request.getAttribute("search");
session.setAttribute("searchbean",searchbean); */
%>
<table align="center" bgcolor="white">
<tr><td><b>Cab name</b></td><td><b>Cab Number</b></td><td><b>Seating Capacity</b></td>
<td><b>Vehicle Type</b></td><td><b>Fare Per KM</b></td></tr>
<%
for (Iterator iterator=list.iterator(); iterator.hasNext();)
{
	Object[] vehicle=(Object[])iterator.next();
	%>
<tr><td><%=vehicle[0] %></td><td><%=vehicle[1] %></td><td><%=vehicle[2] %></td>
<td><%=vehicle[3] %></td><td><%=vehicle[4] %></td>
<td><a href="BookTicket?vid=<%=vehicle[1] %>">Book Now</a></td></tr>

<% } %>
</table>

<a href="customerhome">GO to home</a>
</body>
</html>
