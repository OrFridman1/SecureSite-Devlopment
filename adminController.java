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



 
public class adminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	public adminController() {
		super();
	}
	
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
 
		Connection c = null;
		HttpSession session=request.getSession(false);
		
		//System.out.print(request.getAttributeNames());
		
		List<String> list2 = new ArrayList<String>();
	    RequestDispatcher rd = null;
		try {
		c = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\аеш\\workspace2\\SecureDev\\resource\\db.sqlite");
		PreparedStatement stmt= c.prepareStatement("select * from tblusers");
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
            do {
            	String id = rs.getString(1);
        		String is_admin = rs.getString(3);
                list2.add(id);
                list2.add(is_admin);
            } while (rs.next());
		}    
            
            session.setAttribute("list2", list2);
            
           
	
		rd = request.getRequestDispatcher("/admin.jsp");
		rd.forward(request, response);
		c.close();
		}
		catch(Exception e)
		{
			return;
		}
	
	}
 
}