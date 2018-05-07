package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean.User;
import com.connect.ConnectionProvider;

public class LoginDao {
	
public String daoLogin(User u) {
		
		
		Connection conn = ConnectionProvider.getConn();
		try {
			PreparedStatement ps1 = conn.prepareStatement("select * from users where email=? and password=?");
			ps1.setString(1,u.getEmail());
			ps1.setString(2,u.getPassword());
			 ResultSet rs = ps1.executeQuery();
			if (rs.next()) {
				
				return "Successfully Login User...";
				
			}else {
			return "User Not Regester";	
			
			}
			
		}catch (Exception e) {
				e.printStackTrace();
			}
		return "Fail!!";
}
}
