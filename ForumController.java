package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



 
public class ForumController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	public ForumController() {
		super();
	}
	
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
 
		Connection c = null;
		HttpSession session=request.getSession(false);
		List<String> list = new ArrayList<String>();
	    RequestDispatcher rd = null;
		try {
		c = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\аеш\\workspace2\\SecureDev\\resource\\db.sqlite");
		PreparedStatement stmt= c.prepareStatement("select * from tblforum");
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
            do {
            	String name = rs.getString(1);
        		String message = rs.getString(2);
        		String date = rs.getString(3);
                list.add(name);
                list.add(message);
                list.add(date);
            } while (rs.next());
		}    
            
            session.setAttribute("list", list);
            
           
	
		rd = request.getRequestDispatcher("/forum.jsp");
		rd.forward(request, response);
		c.close();
		}
		catch(Exception e)
		{
			return;
		}
	
	}
 
}