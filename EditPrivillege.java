package controllers;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Authenticator;

import sun.text.normalizer.ICUBinary.Authenticate;
 
@SuppressWarnings("unused")
public class EditPrivillege extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditPrivillege() {
		super();
	}
	
	/*
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * Function that handles the POST request that comes from login.jsp page.
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	*/
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
 
		Connection c = null;
		RequestDispatcher rd = null;
		final Pattern hasUppercase = Pattern.compile("\\p{javaUpperCase}");
		final Pattern hasLowercase = Pattern.compile("\\p{javaLowerCase}");
		final Pattern hasNumber = Pattern.compile("\\p{javaDigit}");
		HttpSession session=request.getSession(false);
	    String id=(String)session.getAttribute("uid");
		
		//Authenticator authenticator = new Authenticator();
		//String result = authenticator.authenticateRegitration(id);
	    //String result="failure";
	    
		
			
			try{
			
			c = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\аеш\\workspace2\\SecureDev\\resource\\db.sqlite");
			
			String target_id = request.getParameter("target_id2");
			String isAdmin = request.getParameter("isAdmin2");
			
			
			
	      
	        
			PreparedStatement stmt= c.prepareStatement("Update tblusers SET isAdmin=? where tblusers.id=?");

			stmt.setString(1, isAdmin);
			stmt.setString(2, target_id);
			
			stmt.executeUpdate();
			System.out.println("test");
			rd = request.getRequestDispatcher("/success2.jsp");
			rd.forward(request, response);
			c.close();
			
			}
			catch(Exception e)
			{
				e.getCause();
			}
		
		
		} 
		
		

	}
 
