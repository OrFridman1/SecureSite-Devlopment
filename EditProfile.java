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
public class EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditProfile() {
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
		
		Authenticator authenticator = new Authenticator();
		String result = authenticator.authenticateRegitration(id);

		if (result.equals("failure")) 
		{
			
			try{
			
			c = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\аеш\\workspace2\\SecureDev\\resource\\db.sqlite");
			String firstName = request.getParameter("first_username");
			String lastName = request.getParameter("last_username");
			String weight = request.getParameter("Weight");
			String height = request.getParameter("Height");
			String email = request.getParameter("user_email");
			String confEmail = request.getParameter("confirm_user_email");
			String age = request.getParameter("Age");
			int valweight=Integer.parseInt(weight);
			
			if((valweight<30) || (valweight>190))
			{
				rd = request.getRequestDispatcher("/errorReg.jsp");
				rd.forward(request, response);
				c.close();
				return;
			}
			int valheight=Integer.parseInt(height);
			if((valheight<145) || (valheight>230))
			{
				rd = request.getRequestDispatcher("/errorReg.jsp");
				rd.forward(request, response);
				c.close();
				return;
			}
			int valage=Integer.parseInt(age);
			if((valage<15) || (valage>70))
			{
				rd = request.getRequestDispatcher("/errorReg.jsp");
				rd.forward(request, response);
				c.close();
				return;
			}
			String valfirst = firstName.trim();
			String vallast = lastName.trim();
		    if(valfirst == null || valfirst.equals(""))
		    {
				rd = request.getRequestDispatcher("/errorReg.jsp");
				rd.forward(request, response);
				c.close();
				return;
			}

		    if(!valfirst.matches("[a-zA-Z]*") || (hasNumber.matcher(valfirst).find()))
		    {
				rd = request.getRequestDispatcher("/errorReg.jsp");
				rd.forward(request, response);
				c.close();
				return;
			}
		    if(vallast == null || vallast.equals(""))
		    {
				rd = request.getRequestDispatcher("/errorReg.jsp");
				rd.forward(request, response);
				c.close();
				return;
			}

		    if(!vallast.matches("[a-zA-Z]*"))
		    {
				rd = request.getRequestDispatcher("/errorReg.jsp");
				rd.forward(request, response);
				c.close();
				return;
			}
		    
		    String valmail = email.trim();

		    if(valmail == null || valmail.equals(""))
		    {
				rd = request.getRequestDispatcher("/errorReg.jsp");
				rd.forward(request, response);
				c.close();
				return;
			}
		    if(confEmail.compareTo(email)<0)
		    {
		    	rd = request.getRequestDispatcher("/errorReg.jsp");
				rd.forward(request, response);
				c.close();
				return;	
		    }
		    if(!valmail.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"))
		    {
				rd = request.getRequestDispatcher("/errorReg.jsp");
				rd.forward(request, response);
				c.close();
				return;
			}

	      
	        
			PreparedStatement stmt= c.prepareStatement("Update tblprofiles SET firstname=?,lastname=?,weight=?,height=?,email=?,age=? where tblprofiles.id=?");

			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			stmt.setString(3, weight);
			stmt.setString(4, height);
			stmt.setString(5, email);
			stmt.setString(6, age);
			stmt.setString(7, id);
			stmt.executeUpdate();
			
			rd = request.getRequestDispatcher("/success2.jsp");
			rd.forward(request, response);
			c.close();
			
			}
			catch(Exception e)
			{
				e.getCause();
			}
		
		
		} 
		else
		{
			rd = request.getRequestDispatcher("/errorReg.jsp");
			rd.forward(request, response);
		}
		

	}
 
}