<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Fridan's Gym home page</title>
 <link rel="stylesheet" type="text/css" href="css/styles.css"  /> 
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
            <li><a href="Recommend">Recommendations</a></li>
            <li><a href="contact.html">Forum</a></li>
        </ul>
    </div>
    

</div><!---menu-wrap-End--->

  
<div class="banner-wrap">
	<div class="banner">
    	<div class="banner-img"></div>
    	<h1> You'r weakly training program and BMI:</h1>
	
	<br><br> <br>
	
 	<h3>Sunday: ${sun} </h3>
  	<h3>Monday: ${mon} </h3>
 	<h3>Thirsday: ${thi} </h3>
	<h3>Wendsday: ${wen}</h3>
	<h3>Tuesday: ${tue}</h3>
	<h3>Your BMI is: ${bmi}</h3>
	 </div>
    
    </div>
    <div class="shadow">
    
    </div>
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
