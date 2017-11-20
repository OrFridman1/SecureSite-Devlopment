package model;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




public class Authenticator {
	/*
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * Authentication function is responsible to perform the connection to the database.
	 * In addition, the function is responsible for the authentication process.
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 */  
	
	public String authenticateLogin(String id, String password) 
	{
		
		Connection c = null;
		try{
			Class.forName("org.sqlite.JDBC");
			
			//~~~~~~~~~~~~~~~Change The path of the SQLite database.~~~~~~~~~~~~~~~~~~~~~~
			
			
			String sunday ="Back workout"; 
			String monday ="Back workout"; 
			String thirsday = "Back workout";
			String wendsday = "Back workout";
			String tuesday = "Back workout";
			c = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\аеш\\workspace2\\SecureDev\\resource\\db.sqlite");			
			PreparedStatement stmt= c.prepareStatement("select * from tblusers where id=? and password=?");
			stmt.setString(1, id);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			

		
			if (rs.next()) 
				{
					PreparedStatement stmt1= c.prepareStatement("select * from tbltraining where id=?");
					stmt1.setString(1, id);
					ResultSet rs1 = stmt1.executeQuery();
					if(!rs1.next())
					{
						stmt1= c.prepareStatement("INSERT into tbltraining values(?,?,?,?,?,?)");
						stmt1.setString(1, id);
						stmt1.setString(2, sunday);
						stmt1.setString(3, monday);
						stmt1.setString(4, thirsday);
						stmt1.setString(5, wendsday);
						stmt1.setString(6, tuesday);
						stmt1.executeUpdate();	
					}
					c.close();
					return "success";
				} 
			else
				{
					c.close();
					return "failure";
				}
			}
			catch(Exception e)
				{
					return "SQL ERROR";
				}
	}
	
	
	
	public String is_Admin(String id) 
	{
		
		Connection c = null;
		try{
			Class.forName("org.sqlite.JDBC");
			
			//~~~~~~~~~~~~~~~Change The path of the SQLite database.~~~~~~~~~~~~~~~~~~~~~~
			
			c = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\аеш\\workspace2\\SecureDev\\resource\\db.sqlite");			
			PreparedStatement stmt= c.prepareStatement("select * from tblusers where id=?");
			stmt.setString(1, id);
			
			ResultSet rs = stmt.executeQuery();
			String isAdmin=rs.getString(3);
			c.close();
			
			return isAdmin;}
			
			catch(Exception e)
				{
					return "SQL ERROR"; 
				}
	}
	
	
	
	
	
	public String authenticateRegitration(String id) 
	{
		
		Connection c = null;
		try{
			Class.forName("org.sqlite.JDBC");
			
			//~~~~~~~~~~~~~~~Change The path of the SQLite database.~~~~~~~~~~~~~~~~~~~~~~
			
			c = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\аеш\\workspace2\\SecureDev\\resource\\db.sqlite");			PreparedStatement stmt= c.prepareStatement("select * from tblprofiles where id=?");
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			c.close();
			if (rs.next()) {
				return "failure";//user is already exist
			} 
			else
				{
				return "success";//create new user				
				}
			}
			
			catch(Exception e)
				{
					return "SQL ERROR";
				}
		
	}
	public String authenticateTraining(String id) 
	{
		
		Connection c = null;
		try{
			Class.forName("org.sqlite.JDBC");
			
			//~~~~~~~~~~~~~~~Change The path of the SQLite database.~~~~~~~~~~~~~~~~~~~~~~
			
			c = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\аеш\\workspace2\\SecureDev\\resource\\db.sqlite");			PreparedStatement stmt= c.prepareStatement("select * from tbltraining where id=?");
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			c.close();
			if (rs.next()) {
				return "failure";//user is already exist
			} 
			else
				{
				return "success";//create new user				
				}
			}
			
			catch(Exception e)
				{
					return "SQL ERROR";
				}
		
	}
}