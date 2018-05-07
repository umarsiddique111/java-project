package com.connect;

import java.sql.Connection;
import java.sql.DriverManager;

public final class ConnectionProvider {
	
static	Connection c=null;
	private ConnectionProvider()
	{
		
	}

	
	public static Connection getConn() 
	{
		
		if(c == null) {
			
			
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				c = DriverManager.getConnection("jdbc:mysql://localhost:3306/demotest", "root", "str0ng");
				return c;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			return c;
		}
		return c;
		
	}
}
