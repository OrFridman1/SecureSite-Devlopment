package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



 
public class Recommendations extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	public Recommendations() {
		super();
	}
	
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
 
		Connection c = null;
		HttpSession session=request.getSession(false);
	    String myId=(String)session.getAttribute("uid");
	    RequestDispatcher rd = null;
	    
		try {
		c = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\аеш\\workspace2\\SecureDev\\resource\\db.sqlite");		PreparedStatement stmt= c.prepareStatement("select * from tblprofiles where id=?");
		stmt.setString(1, myId);
		ResultSet rs = stmt.executeQuery();
		String fn = rs.getString(2);
		String ln = rs.getString(3);
		String w = rs.getString(4);
		String h = rs.getString(5);
		double weight=Double.parseDouble(w);
		double height=Double.parseDouble(h);
		double bmi = (weight/(height*height))*10000;
		session.setAttribute("bmi", bmi);
		session.setAttribute("fn", fn);
		session.setAttribute("ln", ln);
		if((bmi>=18.5) && (bmi<=25))
			session.setAttribute("reco", "You'r BMI is excellent, we recommended for you to split all the workout excercises equaly");
		else
			if(bmi<18.5)
				session.setAttribute("reco", "You'r BMI is to low, we recommended for you to do 80% strength workout excercises and 20% aerobic over the week");
			else
				session.setAttribute("reco", "You'r BMI is to high,we recommended for you to do 80% aerobic workout excercises and 20% strength over the week");
				
		c.close();
	
		if (rs.next()) {
			rd = request.getRequestDispatcher("/recommendations.jsp");//success
		} 
		else
			{
			rd = request.getRequestDispatcher("/error.jsp");//error
			}
		
		rd.forward(request, response);
		}
		catch(Exception e)
		{
			return;
		}
	
	}
 
}