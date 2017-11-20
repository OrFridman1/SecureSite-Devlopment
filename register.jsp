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
			
		 <h1>Sign Up</h1>
		 <h2>Step 1 - fill in the form</h2>	
<BR>
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
      
      
    </body>
</html>