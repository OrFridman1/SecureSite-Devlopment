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
	


	
	
<div class="header-wrap">
	<div class="logo">
		<h1>Fridman's Gym</h1>
    </div>
</div><!---header-wrap-End--->

<div class="menu-wrap">
	<div class="menu">
		<ul>
        	<li><a href="LogoutController" class="active">Logout</a></li>
            <li><a href="ProfileController">Profile</a></li>
            <li><a href="Information">Info</a></li>
            <li><a href="training.jsp">Training</a></li>
            <li><a href="Recommendations">Recommend</a></li>
            <li><a href="contact.html">Forum</a></li>
        </ul>
    </div>
    

</div><!---menu-wrap-End--->

  
<div class="banner-wrap">
	<div class="banner">
    	<div class="banner-img">
   	
    </div>
    <div class="shadow"></div>
    <h1>Welcome ${fn}</h1>
	<br><br><br>
	<form action="editprofile.jsp" method="post">
	<input type="submit" value="Edit profile"/>	
	</form>
	<img src="images/${pic}" height="30" width="30"  />
 	<h3>Id: ${id} </h3>
  	<h3>First Name: ${fn} </h3>
 	<h3>Last Name: ${ln} </h3>
	<h3>Age: ${a}</h3>
	<h3>Height: ${h}</h3>
	<h3>Weight: ${w}</h3> </div>
	


</div><!---banner-wrap-End--->

<div class="page-wrap">
<div class="wrap">
	
</div>
</div>
<div class="footer-wrap">
  <div class="wrap">
    <div class="panel marRight30">
      <div class="title">
        <h1>About us</h1>
      </div>
	</div>
    <div class="panel marRight30">
      <div class="title">
        <h1>Help</h1>
      </div>
      </div>
      
 	<div class="panel marRight30">
      <div class="title">
        <h1>Jobs</h1>
      </div>
      </div>
      
       <div class="panel marRight30">
      <div class="title">
        <h1>Terms</h1>
      </div>
      </div>
       <div class="panel marRight30">
      <div class="title">
        <h1>Privacy</h1>
      </div>
      </div>
       <div class="panel marRight30">
      <div class="title">
        <h1>Contact us</h1>
      </div>
      </div>
      </div>
</div><!---footer-wrap--->
</body>
</html>