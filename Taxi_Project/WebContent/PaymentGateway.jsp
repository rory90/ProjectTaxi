<!--
Advanced Programming 
Rory Adamson   0903081
Travis Hibbert 1503333
Tutor: Gilroy Gordon 
-->


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.utech.ap.Taxi_Project.Entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gateway</title>
</head>
<body bgcolor=CadetBlue >
<div style="text-align:center; padding:5px;background-color: Teal;">
<h1 align="center">Welcome <%=session.getAttribute("loginid") %></h1>
<h1 align="center">Welcome to Hill Top Travel Agency </h1>
</div>
<%
Booking bookingbean=(Booking)session.getAttribute("booking");
%>
<h1 align="center">Please pay <%=bookingbean.getFare() %> to confirm booking</h1>
<h2 align="center" >${message}</h2>
<form action="BookCheck" >
<table align="center">
<tr>
<td>card number</td><td><input type="text" name="CardNumber" ></td></tr>
<tr><td>valid from</td><td><input type="text" name="validFrom" ></tr>
<tr><td>valid to</td><td><input type="text" name="validTo" ></td></tr>
<!-- <tr><td>card balance</td><td><input type="text" name="creditBalance" ></td></tr> -->
<tr><td></td><td> <input type="submit" name=submit value=pay></td></tr>
</table>
</form>

</body>
</html>
