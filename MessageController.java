package controllers;	
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import model.Authenticator;

	import sun.text.normalizer.ICUBinary.Authenticate;
	 
	@SuppressWarnings("unused")
	public class MessageController extends HttpServlet {
		private static final long serialVersionUID = 1L;

		public MessageController() {
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
			HttpSession session=request.getSession();
		    String firstName;
		    String myId=(String)session.getAttribute("uid");
		    String mes = request.getParameter("message");
		    List<String> list = new ArrayList<String>();
		    
		    if(mes == null)
		    {
		    	JOptionPane.showMessageDialog(null, "You need to write message", "Error", JOptionPane.INFORMATION_MESSAGE);
		    	rd = request.getRequestDispatcher("/forum.jsp");
				rd.forward(request, response);
		    }
		    String date = new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime());
			
				try{
				c = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\аеш\\workspace2\\SecureDev\\resource\\db.sqlite");				
				PreparedStatement stmt2= c.prepareStatement("select * from tblprofiles where id=?");
				stmt2.setString(1, myId);
				ResultSet rs2 = stmt2.executeQuery();
				firstName = rs2.getString(2);
		        
				PreparedStatement stmt= c.prepareStatement("INSERT into tblforum values(?,?,?)");

				stmt.setString(1, firstName);
				stmt.setString(2, mes);
				stmt.setString(3, date);
				stmt.executeUpdate();

				PreparedStatement stmt1= c.prepareStatement("select * from tblforum");
				ResultSet rs = stmt1.executeQuery();
				if (rs.next()) {
		            do {
		            	String name = rs.getString(1);
		        		String message = rs.getString(2);
		        		String date1 = rs.getString(3);
		                list.add(name);
		                list.add(message);
		                list.add(date1);
		            } while (rs.next());
				}    
		        session.setAttribute("list", list);
				rd = request.getRequestDispatcher("/forum.jsp");
				rd.forward(request, response);
				c.close();
				
				}
				catch(Exception e)
				{
					e.getCause();
				}
			
			
			} 
			
			

		
	 
	}
