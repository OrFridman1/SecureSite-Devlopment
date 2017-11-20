<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Fridan's Gym home page</title>
 
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
            <li><a href="ForumController">Forum</a></li>
        	<% 
		String admin_check=(String)session.getAttribute("admin");
		
		int s=Integer.parseInt(admin_check);
		
		if(s==1)
		{
			
			out.print("<li><a href=adminController class=active>Admin</a></li>");
			
		}
		
	//	else
		//{
			//System.out.println(admin_check);
			//System.out.println("sasasa");
			//out.print("<h1>lalala</h1>");
			
		//}
		
		%> 
            
            
        </ul>
    </div>
<form action="SearchController" method="post" style="text-align:center" name="search">
      
        
          <fieldset>
    	  <BR>
          <label for="search">search:</label>
          <input type="text" id="search" name="search_word" >
      	  
          <BR>
          
  			<input type="submit" id="sbmt" value="Search"/>
  		</fieldset>
      	</form>    

</div><!---menu-wrap-End--->

  
<div class="banner-wrap">
	<div class="banner">
    	<div class="banner-img"><img src="images/image12.jpg" /></div>
    </div>
    <div class="shadow"></div>
</div><!---banner-wrap-End--->

<div class="page-wrap">
<div class="wrap">
	
    	<h1>A gym, short for gymnasium, is an open air or covered location for gymnastics, athletics, and gymnastic services. The word is derived from the ancient Greek gymnasium. They are commonly found in athletic and fitness centers, and as activity and learning spaces in educational institutions. "Gym" is also slang for "fitness center", which is often an indoor facility. </h1>
</div>
</div>

<div class="footer-wrap">
  <div class="wrap">
    <div class="marRight30">
      <div class="title">
        <h1>About us</h1>
      </div>
	</div>
    <div class="marRight30">
      <div class="title">
        <h1>Help</h1>
      </div>
      </div>
      
 	<div class="marRight30">
      <div class="title">
        <h1>Jobs</h1>
      </div>
      </div>
      
       <div class="marRight30">
      <div class="title">
        <h1>Terms</h1>
      </div>
      </div>
       <div class="marRight30">
      <div class="title">
        <h1>Privacy</h1>
      </div>
      </div>
       <div class="marRight30">
      <div class="title">
        <h1>Contact us</h1>
      </div>
      </div>
      </div>
</div><!---footer-wrap--->
</body>
</html>
