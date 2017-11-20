package controllers;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import model.Authenticator;


 
//import sun.text.normalizer.ICUBinary.Authenticate;
 
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int login_fail_count=0;
	public LoginController() {
		super();
		
	}
	
	/*
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * Function that handles the POST request that comes from login.jsp page.
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	*/
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		
			
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		RequestDispatcher rd = null;
		Authenticator authenticator = new Authenticator();
		String result = authenticator.authenticateLogin(id, password);
		
		if (result.equals("success")) 
		{		
				
				rd = request.getRequestDispatcher("/success2.jsp");
				HttpSession session=request.getSession();
				session.setAttribute("uid",id);
				String admin=authenticator.is_Admin(id);
				session.setAttribute("admin",admin);
				
		}  
		else
		{			
			login_fail_count++;
			System.out.println(login_fail_count);
			if(login_fail_count>3)
			{
			
			
				login_fail_count=0;
				//JOptionPane.showMessageDialog(null, "You have been blocked! wait 10 seconds", "Error", JOptionPane.INFORMATION_MESSAGE);
				
				rd = request.getRequestDispatcher("/block3.jsp");	
			}
			else
			{
			JOptionPane.showMessageDialog(null, "The username or the password is incorrect", "Error", JOptionPane.INFORMATION_MESSAGE);
			rd = request.getRequestDispatcher("/login2.jsp");
			}
		}
		
		rd.forward(request, response);
		
	}
	
	}
 
