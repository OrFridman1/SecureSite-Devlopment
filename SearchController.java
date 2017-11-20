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



 
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	public SearchController() {
		super();
	}
	
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
 
		Connection c = null;
		HttpSession session=request.getSession(false);
		List<String> list3 = new ArrayList<String>();
	    RequestDispatcher rd = null;
	    //String search=(String)session.getAttribute("search_word");
	    String search=(String)request.getParameter("search_word");
	    String search_all="'%"+search+"%'";
	    System.out.println(search);
	    System.out.println(search_all);
	    session.setAttribute("search1", search);
		try {
		c = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\аеш\\workspace2\\SecureDev\\resource\\db.sqlite");
		PreparedStatement stmt= c.prepareStatement("select * from tblsearch where question like ?");
		stmt.setString(1, "%" + search + "%");
		//ps.setString(1, "%" + opt + "%");
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
            do {
            	String answer = rs.getString(2);
                list3.add(answer);
            } while (rs.next());
		}    
            
            session.setAttribute("list3", list3);
            
           
	
		rd = request.getRequestDispatcher("/search.jsp");
		rd.forward(request, response);
		c.close();
		}
		catch(Exception e)
		{
			return;
		}
	
	}
 
}