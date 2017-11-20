<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <title>Fridman's Gym</title>
  <meta http-equiv="content-type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="css/style.css" />
</head>


<body>

<div id="main">	
	<div id="site_content">
      <div id="heading">
	    <div class="site_heading">
	      <h1><span>Fridman's</span> Gym</h1>	
	    </div><!--close site_heading-->
        <div class="site_slogan">	  
		  <h2>#1 Sport's Club</h2>
        </div><!--close site_slogan-->
	  </div><!--close heading-->


<div id="header">
	    <div id="menubar">
          <ul id="menu">
           
        </div><!--close menubar-->
      </div><!--close header-->	 




	          <center>
   <h1>Sign Up</h1>
		 <h2>Step 1 - fill in the form</h2></center>	
<br>
<left></left>

        <form action="RegistrationController" method="post" style="text-align:center" name="regValidate">
      
       
        <BR>
          <fieldset>
          <legend><span class="number">1.</span>Your basic info</legend>
      
    	  <BR>
          <label for="Name">First Name:</label>
          <input type="text" id="first_name" name="first_username" >
      	  <BR>
          <BR>
          <label for="Last Name">Last Name:</label>
          <input type="text" id="last_name" name="last_username" >
          <BR>
          <BR>
          <label for="id">ID:</label>
          <input type="text" id="id" name="id" >
          <BR>
          <BR>
          <label for="mail">Email:</label>
          <input type="text" id="mail" name="user_email" >
          <BR>
          <BR>
          <label for="mail">Confirm Email:</label>
          <input type="text" id="confirm_mail" name="confirm_user_email" >
          <BR>
          <BR>
          <label for="password">Password:</label>
          <input type="password" id="password" name="user_password">
          <BR>
          <BR>
          <label for="password">Confirm Password:</label>
          <input type="password" id="confirm_password" name="confirm_user_password" >
          <BR>
          <BR>
          <label for="Weight:">Weight:</label>
          <input type="text" id="Weight" name="Weight" >
          <BR>
          <BR>
          <label for="Height:">Height:</label>
          <input type="text" id="Height" name="Height" >
          <BR>
          <BR>
          <label for="Age:">Age:</label>
          <input type="text" id="Age" name="Age">
         <BR>    
         <BR>
  			<input type="submit" id="sbmt" value="Proceed"/>
  			<input type="reset" value=" Reset "> 
  		</fieldset>
      	</form>
	
		
	 <!--close banner_image-->			  
	  <div id="content">
<p></p><br>
		<div class="content_underline"></div>
</div></div>


<div id="footer">  
     About us | Help | Jobs | Terms | Privacy | Contact Us
    </div><!--close footer-->	
    </div>
 <!--close main-->	



<!---footer-wrap--->
</body>
</html>
