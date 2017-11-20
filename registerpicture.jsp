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
		 <h2>Step 2 - upload your picture</h2>	
<BR><BR><BR>
<form action="UploadServlet" method="post" style="text-align:center" enctype="multipart/form-data">
<label for="Photo:">Upload Photo:</label>
<input type="file" name="file" size="50" />
<br />
<input type="submit" value="Upload File" />
<br><br>
</form>
      
      
    </body>
</html>