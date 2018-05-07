package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import com.bean.User;
import com.connect.ConnectionProvider;
import com.util.SendMail;



public class UserDao {
	
	public String daoRegester(User u) {
		
		
		Connection conn = ConnectionProvider.getConn();
		try {
			PreparedStatement ps1 = conn.prepareStatement("select * from users where email=?");
			ps1.setString(1,u.getEmail());
			 ResultSet rs = ps1.executeQuery();
			if (rs.next()) {
				
				return "User already exsit...";
				
			}else {
			
		PreparedStatement ps = conn.prepareStatement("insert into users values(?,?,?,?,?)");
		
		int otp = new Random().nextInt(88888888);
		ps.setString(1,u.getName());
		ps.setString(2,u.getPassword());
		ps.setString(3,u.getEmail());
		ps.setString(4,"Inactive");
		ps.setInt(5,otp);
	
		
		int i = ps.executeUpdate();
		
		if(i>0) {
			
			boolean issend =SendMail.sendMail(u.getEmail(), "Generated:", "OTP"+otp);
			if(issend == true) {
				return "Successfully!!";	
			}else {
				return "Fails";
			}
			
	} else {
			return "Fail!!";
		}
		
		}
		}catch (Exception e) {
		e.printStackTrace();
		}
		
		return "return msg";
	}

}
