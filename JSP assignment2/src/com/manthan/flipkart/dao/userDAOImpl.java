package com.manthan.flipkart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.manthan.flipkart.bean.Userinfobeans;
import com.mysql.jdbc.Driver;

public class userDAOImpl implements userDAO {
	@Override
	public boolean adduser(Userinfobeans userInfoBeans) {
		Connection con=null;
		PreparedStatement pstmt=null;
		boolean isAdded=false;
		try {
			Driver d=new Driver();
			DriverManager.registerDriver(d);
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Flipkart?user=root&password=root"); 
			String query= "insert into User_info values(?,?,?,?)";
			pstmt = (PreparedStatement) con.prepareStatement(query);
			pstmt.setInt(1,userInfoBeans.getuserid());
			pstmt.setString(2, userInfoBeans.getusername());
			pstmt.setString(3,userInfoBeans.getemail());
			pstmt.setString(4,userInfoBeans.getpassword());
			int n=pstmt.executeUpdate();
			if(n>0) {
				isAdded=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return isAdded;
	}

}
