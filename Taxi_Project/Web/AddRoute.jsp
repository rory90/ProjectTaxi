<!--
Advanced Programming 
Rory Adamson 0903081
Travis Hibbert 153
Tutor: Gilroy Gordon 
-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Route</title>
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
 padding-top: 0%;
}
td{
color: #fff;
}
</style>
</head>
<body bgcolor=CadetBlue >
<div  id="main" style="text-align:center; padding:5px;background-color: Teal;">
<h1 align="center">Welcome Administrator</h1>
<h1 align="center">Welcome to Hill Top Travel Agency </h1>
</div>
<h1>${Warning}</h1>
<a id="home" href="home">Home</a>
<h2 align="center" style="color:#fff;">Please Enter Route details </h2>

<form  action="routemain" METHOD=POST>
<table align="center" cellspacing="10">
<tr><td> Source</td><td><input type="text" name="source" autofocus></td></tr>
<tr><td>Destination</td><td><input type="text" name="destination"></td></tr>
<tr><td>Distance</td><td><input type="text" name="distance" value=0></td></tr>
<tr><td>Duration</td><td><input type="text" name="duration" value=0></td></tr>

<tr><td></td><td><input type="submit" value="Add Route" style="margin: 8%; margin-left: 28%; background-color: #5cb85c; color:#fff; border-color: #4cae4c; padding:3%;"></td></tr>
</table>
</form>
</body>
</html>
