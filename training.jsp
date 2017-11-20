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
            <li class="current"><a href="LogoutController">Logout</a></li>
            <li><a href="ProfileController">Profile</a></li>
            <li><a href="Information">Personal Info</a></li>
            <li><a href="training.jsp">Training Program</a></li>
           
             <li><a href="Recommendations">Recommendations</a></li>
             <li><a href="ForumController">Forum</a></li>
             <% 
		String admin_check=(String)session.getAttribute("admin");
		
		int s=Integer.parseInt(admin_check);
		
		if(s==1)
		{
			
			out.print("<li><a href=adminController class=active>Admin</a></li>");
			
		}
		%>
          </ul>
        </div><!--close menubar-->
      </div><!--close header-->	 



<form action="SearchController" method="post" style="text-align:center" name="search">
      
        
          <fieldset>
    	  <BR>
          <label for="search">search:</label>
          <input type="text" id="search" name="search_word" >
      	  
          <BR>
          
  			<input type="submit" id="sbmt" value="Search"/>
  		</fieldset>
      	</form>    
  
		  
	  <div id="content">
	<center>
	<h1>Create Your Weekly Training Program</h1><br>
<form action="TrainingController" method="post">
	Sunday:<select name="sunday">
  	<option value="Back workout">Back workout</option>
  	<option value="Legs workout">Legs workout</option>
  	<option value="Chest workout">Chest workout</option>
  	<option value="Hands workout">Hands workout</option>
  	<option value="Swiming workout">Swiming workout</option>
  	<option value="Aerobic workout">Aerobic workout</option>
	<option value="Stomech workout">Stomech workout</option>
	<option value="Mass workout">Mass workout</option>  	
	</select>
	<br><br>
	Monday:<select name="monday">
  	<option value="Back workout">Back workout</option>
  	<option value="Legs workout">Legs workout</option>
  	<option value="Chest workout">Chest workout</option>
  	<option value="Hands workout">Hands workout</option>
  	<option value="Swiming workout">Swiming workout</option>
  	<option value="Aerobic workout">Aerobic workout</option>
	<option value="Stomech workout">Stomech workout</option>
	<option value="Mass workout">Mass workout</option>  	
	</select>
	<br><br>
	Thursday:<select name="thirsday">
  	<option value="Back workout">Back workout</option>
  	<option value="Legs workout">Legs workout</option>
  	<option value="Chest workout">Chest workout</option>
  	<option value="Hands workout">Hands workout</option>
  	<option value="Swiming workout">Swiming workout</option>
  	<option value="Aerobic workout">Aerobic workout</option>
	<option value="Stomech workout">Stomech workout</option>
	<option value="Mass workout">Mass workout</option>  	
	</select>
	<br><br>
	Wednesday:<select name="wendsday">
  	<option value="Back workout">Back workout</option>
  	<option value="Legs workout">Legs workout</option>
  	<option value="Chest workout">Chest workout</option>
  	<option value="Hands workout">Hands workout</option>
  	<option value="Swiming workout">Swiming workout</option>
  	<option value="Aerobic workout">Aerobic workout</option>
	<option value="Stomech workout">Stomech workout</option>
	<option value="Mass workout">Mass workout</option>  	
	</select>
	<br><br>
	Tuesday:<select name="tuesday">
  	<option value="Back workout">Back workout</option>
  	<option value="Legs workout">Legs workout</option>
  	<option value="Chest workout">Chest workout</option>
  	<option value="Hands workout">Hands workout</option>
  	<option value="Swiming workout">Swiming workout</option>
  	<option value="Aerobic workout">Aerobic workout</option>
	<option value="Stomech workout">Stomech workout</option>
	<option value="Mass workout">Mass workout</option>  	
	</select>
	<br><br>
	<input type="submit" value="Send"/>
	</form>
	<br>
	
	
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
