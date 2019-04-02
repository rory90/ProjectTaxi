<!--
Advanced Programming 
Rory Adamson   0903081
Travis Hibbert 1503333
Tutor: Gilroy Gordon 
-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.utech.ap.Taxi_Project.Entity.PaymentHistory"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cancellation Success</title>
</head>
<body bgcolor=CadetBlue >
<div style="text-align:center; padding:5px;background-color: Teal;">
<h1 align="center">Welcome <%=session.getAttribute("loginid") %></h1>
<h1 align="center">Welcome to Hill Top Travel Agency </h1>
</div>
 <h1>${Warning}</h1>
 <%PaymentHistory history=(PaymentHistory)session.getAttribute("history"); %>
 <h1> Your CreditCard <%=history.getCardNumber()%> has been credited <%=history.getTotalFare() %> rupees </h1>
<a href="customerhome">go to home</a>
</body>
</html>
