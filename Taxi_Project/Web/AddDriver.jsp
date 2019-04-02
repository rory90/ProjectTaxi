<!--
Advanced Programming 
Rory Adamson   0903081
Travis Hibbert 1503333
Tutor: Gilroy Gordon 
-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Driver</title>
<style type="text/css">
#main{
color: #fff;
}
body{
margin-left: 0px;
margin-right: 0px;
margin-top: 0px;
}
#home{
text-decoration : none;
font-weight: 500;
font-size: 20px;
margin: 2.5%;
margin-bottom: 4%;
}
table{
 padding-top: 2%;
}
td{
color: #fff;
}
</style>
</head>
<body bgcolor=CadetBlue>
<div id="main" style="text-align:center; padding:5px;background-color: Teal;">
<h1 align="center">Welcome to Hill Top Travel Agency</h1>
<h2 align="center">Please Add Driver Details</h2>
</div>
<h3 align="center" style="color: red;">${warning}</h3>
<a id="home" href="home">Home</a>
<form  action="drivermain" METHOD=POST>
<table align="center" cellspacing="5">
<tr><td>Cab Number</td><td><input type="text" name=cabNumber autofocus></td></tr>
<tr><td>First Name</td><td><input type="text" name=firstName ></td></tr>
<tr><td>Last Name</td><td><input type="text" name="lastName" ></tr>
<tr><td>License Number</td><td><input type="text" name=licenseNumber></td></tr>
<tr><td>Contact Number</td><td><input type="text" name=contactNumber></td></tr>

<tr><td>House Number</td><td><input type="text" name=houseNumber ></td></tr>
<tr><td>First Line Of Address</td><td><input type="text" name="firstLineOfAddress" ></tr>
<tr><td>Second Line Of Address</td><td><input type="text" name=secondLineOfAddress></td></tr>
<tr><td>City</td><td><input type="text" name=city></td></tr>
<tr><td>Parish</td><td><input type="text" name=parish></td></tr>
<tr><td>Pin Code</td><td><input type="text" name=pinCode></td></tr>
<tr><td></td><td><input type="submit" value="Add Driver" style="margin: 8%; margin-left: 28%; background-color: #5cb85c; color:#fff; border-color: #4cae4c; padding:3%;"></td></tr>
</table>
</form>

</body>
</html>