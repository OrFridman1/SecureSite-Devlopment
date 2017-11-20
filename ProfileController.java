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



 
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	public ProfileController() {
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
		
		String id = rs.getString(1);
		String fn = rs.getString(2);
		String ln = rs.getString(3);
		String w = rs.getString(4);
		String h = rs.getString(5);
		String e = rs.getString(6);
		String a = rs.getString(7);
		session.setAttribute("id", id);
		session.setAttribute("fn", fn);
		session.setAttribute("ln", ln);
		session.setAttribute("w", w);
		session.setAttribute("h", h);
		session.setAttribute("e", e);
		session.setAttribute("a", a);
		session.setAttribute("pic", id + ".jpg");
		
		if (rs.next()) {
			rd = request.getRequestDispatcher("/profile2.jsp");//success
		} 
		else
			{
			rd = request.getRequestDispatcher("/error.jsp");//error
			}
		
		rd.forward(request, response);
		c.close();
		}
		catch(Exception e)
		{
			return;
		}
	
	}
 
}