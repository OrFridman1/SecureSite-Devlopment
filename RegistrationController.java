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
import javax.swing.JOptionPane;

import model.Authenticator;

//import sun.text.normalizer.ICUBinary.Authenticate;
 
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistrationController() {
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
		String id = request.getParameter("id");
		HttpSession session=request.getSession();
		session.setAttribute("pid", id);
		if((id.length() != 9) &&( hasNumber.matcher(id).find()) ||(hasUppercase.matcher(id).find()) || (hasLowercase.matcher(id).find()))
		{
			System.out.println("id");
			JOptionPane.showMessageDialog(null, "The id is invalid", "Error", JOptionPane.INFORMATION_MESSAGE);
			rd = request.getRequestDispatcher("/register2.jsp");
			rd.forward(request, response);
			return;
		}
		Authenticator authenticator = new Authenticator();
		String result = authenticator.authenticateRegitration(id);

		if (result.equals("success")) 
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
			String password = request.getParameter("user_password");
			String confPassword = request.getParameter("confirm_user_password");
			int valweight=Integer.parseInt(weight);
			System.out.println("testy");
			if((valweight<30) || (valweight>190) )
			{
				System.out.println("weight");
				JOptionPane.showMessageDialog(null, "The weight is invalid", "Error", JOptionPane.INFORMATION_MESSAGE);
				rd = request.getRequestDispatcher("/register2.jsp");
				rd.forward(request, response);
				c.close();
				return;
			}
			int valheight=Integer.parseInt(height);
			if((valheight<145) || (valheight>230))
			{
				System.out.println("height");
				JOptionPane.showMessageDialog(null, "The height is invalid", "Error", JOptionPane.INFORMATION_MESSAGE);
				rd = request.getRequestDispatcher("/register2.jsp");
				rd.forward(request, response);
				c.close();
				return;
			}
			int valage=Integer.parseInt(age);
			if((valage<15) || (valage>70))
			{
				System.out.println("age");
				JOptionPane.showMessageDialog(null, "The age is invalid", "Error", JOptionPane.INFORMATION_MESSAGE);
				rd = request.getRequestDispatcher("/register2.jsp");
				rd.forward(request, response);
				c.close();
				return;
			}
			String valfirst = firstName.trim();
			String vallast = lastName.trim();
		    if(valfirst == null || valfirst.equals(""))
		    {
		    	System.out.println("fname");
				JOptionPane.showMessageDialog(null, "The first name is invalid", "Error", JOptionPane.INFORMATION_MESSAGE);
		    	rd = request.getRequestDispatcher("/register2.jsp");
				rd.forward(request, response);
				c.close();
				return;
			}

		    if(!valfirst.matches("[a-zA-Z]*") || (hasNumber.matcher(valfirst).find()))
		    {
		    	System.out.println("fname1");
				JOptionPane.showMessageDialog(null, "The first name is invalid", "Error", JOptionPane.INFORMATION_MESSAGE);
		    	rd = request.getRequestDispatcher("/register2.jsp");
				rd.forward(request, response);
				c.close();
				return;
			}
		    if(vallast == null || vallast.equals(""))
		    {
		    	System.out.println("lname");
				JOptionPane.showMessageDialog(null, "The last name is invalid", "Error", JOptionPane.INFORMATION_MESSAGE);
		    	rd = request.getRequestDispatcher("/register2.jsp");
				rd.forward(request, response);
				c.close();
				return;
			}

		    if(!vallast.matches("[a-zA-Z]*"))
		    {
		    	System.out.println("lname1");
				JOptionPane.showMessageDialog(null, "The last name is invalid", "Error", JOptionPane.INFORMATION_MESSAGE);
		    	rd = request.getRequestDispatcher("/register2.jsp");
				rd.forward(request, response);
				c.close();
				return;
			}
		    
		    String valmail = email.trim();

		    if(valmail == null || valmail.equals(""))
		    {
		    	System.out.println("mail");
				JOptionPane.showMessageDialog(null, "The mail is invalid", "Error", JOptionPane.INFORMATION_MESSAGE);
				rd = request.getRequestDispatcher("/register2.jsp");
				rd.forward(request, response);
				c.close();
				return;
			}
		    if(confEmail.compareTo(email)<0)
		    {
		    	System.out.println("mail1");
		    	System.out.println(email + confEmail);
				JOptionPane.showMessageDialog(null, "The mail and confirm mail isn't match", "Error", JOptionPane.INFORMATION_MESSAGE);
				rd = request.getRequestDispatcher("/register2.jsp");
				rd.forward(request, response);
				c.close();
				return;	
		    }
		    if(!valmail.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"))
		    {
		    	System.out.println("mail2");
		    	JOptionPane.showMessageDialog(null, "The mail is invalid", "Error", JOptionPane.INFORMATION_MESSAGE);
				rd = request.getRequestDispatcher("/register2.jsp");
				rd.forward(request, response);
				c.close();
				return;
			}

	      if ((password.compareTo(confPassword)<0) || (password.length()<8)|| (password.length()>13) || (!hasUppercase.matcher(password).find()) || (password.isEmpty()) || (!hasLowercase.matcher(password).find()) || (!hasNumber.matcher(password).find()))	
			{
	    	  System.out.println("pass");
	    	  JOptionPane.showMessageDialog(null, "The password is invalid", "Error", JOptionPane.INFORMATION_MESSAGE);
				rd = request.getRequestDispatcher("/register2.jsp");
				rd.forward(request, response);
				c.close();
				return;
	        }
	        
			PreparedStatement stmt= c.prepareStatement("INSERT into tblprofiles values(?,?,?,?,?,?,?)");
			stmt.setString(1, id);
			stmt.setString(2, firstName);
			stmt.setString(3, lastName);
			stmt.setString(4, weight);
			stmt.setString(5, height);
			stmt.setString(6, email);
			stmt.setString(7, age);
			stmt.executeUpdate();
			
			PreparedStatement stmt1= c.prepareStatement("INSERT into tblusers values(?,?,?)");
			stmt1.setString(1, id);
			stmt1.setString(2, password);
			stmt1.setString(3, "0");
			stmt1.executeUpdate();
			rd = request.getRequestDispatcher("/registerpicture2.jsp");
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
			JOptionPane.showMessageDialog(null, "This user is already exist!", "Error", JOptionPane.INFORMATION_MESSAGE);
			rd = request.getRequestDispatcher("/register2.jsp");
			rd.forward(request, response);
			
		}
		

	}
 
}