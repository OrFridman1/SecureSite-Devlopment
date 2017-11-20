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
import javax.swing.JOptionPane;



 
public class Information extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	public Information() {
		super();
	}
	
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
 
		Connection c = null;
		HttpSession session=request.getSession(false);
	    String myId=(String)session.getAttribute("uid");
	    RequestDispatcher rd = null;
	    
		try {
		c = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\аеш\\workspace2\\SecureDev\\resource\\db.sqlite");		PreparedStatement stmt= c.prepareStatement("select * from tbltraining where id=?");
		stmt.setString(1, myId);
		ResultSet rs = stmt.executeQuery();
		
		String id = rs.getString(1);
		String sunday = rs.getString(2);
		String monday = rs.getString(3);
		String thirsday = rs.getString(4);
		String wendsday = rs.getString(5);
		String tuesday = rs.getString(6);
		session.setAttribute("id", id);
		session.setAttribute("sun", sunday);
		session.setAttribute("mon", monday);
		session.setAttribute("thi", thirsday);
		session.setAttribute("wen", wendsday);
		session.setAttribute("tue", tuesday);
		
		
		if (rs.next()) {
			rd = request.getRequestDispatcher("/info2.jsp");//success
		} 
		else
			{
			JOptionPane.showMessageDialog(null, "You need to fill out first your weekly training in Training tab", "Error", JOptionPane.INFORMATION_MESSAGE);
	    	rd = request.getRequestDispatcher("/training2.jsp");
			rd.forward(request, response);
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