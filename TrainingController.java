package controllers;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Authenticator;




public class TrainingController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TrainingController() {
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
		String sunday = request.getParameter("sunday");
		String monday = request.getParameter("monday");
		String thirsday = request.getParameter("thirsday");
		String wendsday = request.getParameter("wendsday");
		String tuesday = request.getParameter("tuesday");
		HttpSession session=request.getSession(false);
	    String myId=(String)session.getAttribute("uid");
		Authenticator authenticator = new Authenticator();
		String result = authenticator.authenticateTraining(myId);
		if (result.equals("success")) 
		{
			try {
			c = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\аеш\\workspace2\\SecureDev\\resource\\db.sqlite");			
			PreparedStatement stmt1= c.prepareStatement("INSERT into tbltraining values(?,?,?,?,?,?)");
			stmt1.setString(1, myId);
			stmt1.setString(2, sunday);
			stmt1.setString(3, monday);
			stmt1.setString(4, thirsday);
			stmt1.setString(5, wendsday);
			stmt1.setString(6, tuesday);
			stmt1.executeUpdate();
				
			rd = request.getRequestDispatcher("/success2.jsp");
			rd.forward(request, response);	
			c.close();
			} 
			catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		else
		{
			try {
			c = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\аеш\\workspace2\\SecureDev\\resource\\db.sqlite");			
			PreparedStatement stmt1= c.prepareStatement("Update tbltraining SET sunday=?,monday=?,thirsday=?,wendsday=?,tuesday=? where tbltraining.id=?");
			
			stmt1.setString(1, sunday);
			stmt1.setString(2, monday);
			stmt1.setString(3, thirsday);
			stmt1.setString(4, wendsday);
			stmt1.setString(5, tuesday);
			stmt1.setString(6, myId);
			stmt1.executeUpdate();
				
			rd = request.getRequestDispatcher("/success2.jsp");
			rd.forward(request, response);	
			c.close();
			} 
			catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		

	}
 
}