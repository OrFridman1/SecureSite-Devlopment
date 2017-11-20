<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<% 
List<String> list = new ArrayList<String>();
 list = (List<String>)session.getAttribute("list");%>
<html>
<head>
  <title>Fridman's Gym</title>
  <meta http-equiv="content-type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="css/style.css" />
  <style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
    color:red;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
    color:red;
}




</style>
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
	<table>
  <tr>
  	<th>Number</th>
    <th>Subject</th>
    <th>Name</th>
    <th>Date</th>
  </tr>

<%
    int iter=0;
	int mone=1;
    for(int j=0;j<(list.size()/3);j++)
    {
    	 %> <tr>
    		<th><%=mone %></th>
    		
    		<%
    		mone++;
    		 for (int i = iter; i < list.size(); i++){	 
    			 iter++;
    			%>
    			<th><%=list.get(i) %></th>
    			<%
    			
    			if((iter % 3)==0)
    				break;
    	}%>
    	</tr>
  <%   }
    			%>
    
</table>
<BR><BR>

   
<form action="MessageController" method="post">
		Message: <input type="text" width="300" name="message"> 
		<BR><BR>
		<input type="submit" value="Add message"/>
	</form>    
	
	
		<div class="content_underline"></div>
</div></div><br>


<div id="footer">  
     About us | Help | Jobs | Terms | Privacy | Contact Us
    </div><!--close footer-->	
    </div>
 <!--close main-->	



<!---footer-wrap--->
</body>
</html>
