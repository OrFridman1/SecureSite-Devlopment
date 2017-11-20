<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SecureApp</title>
<link href="css/styles.css" rel="stylesheet" type="text/css" />
<style>
<%@ include file="./css/styles.css"%>
</style>
</head>
<body>
	
	<!-- 
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	The LoginController servlet was mapped in the web.xml file. 
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	-->
	<h1 style="text-align:center;">You hacker! your ass got blocked.</h1>
	<br><br><br>
	
	

<%
Thread.sleep(5000);
response.sendRedirect("./login2.jsp");

%>

	
	<div class="banner-img"><img src="images/ima1.png" alt="" width="900" height="200" /></div>
</body>
</html>