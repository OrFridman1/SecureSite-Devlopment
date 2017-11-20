package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LogoutController extends HttpServlet {
	/*
	 	<cookie-config>
   		<http-only>true</http-only>
   		<secure>true</secure>
   		</cookie-config>
	 */
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LogoutController() {
		super();
	}
	
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = null;
		HttpSession session=request.getSession();
		if(!session.isNew())
		{
			session.invalidate();
			session=request.getSession();
		}
		
		
		rd = request.getRequestDispatcher("/login2.jsp");
		rd.forward(request, response);
	}
 
}