package com.manthan.flipkart.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manthan.flipkart.bean.productinfobeans;




public class productDAOimpl implements productDAO {


	public productinfobeans searchproduct(int proid)  {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

productinfobeans productinfobeans =new productinfobeans();

	try {
		//LOAD THE DRIVER
		Class.forName("com.mysql.jdbc.Driver");

		//GET CONNECTION VIA DRIVER
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Flipkart?user=root&password=root");

		//ISSUE SQL QUERY 
		String query = " select * from employee_info where productid=? ";
		pstmt = con.prepareStatement(query);
		
		
		rs = pstmt.executeQuery();

		if(rs.next()) {

			productinfobeans.setproductId(rs.getInt("productid"));
			productinfobeans.setproductname(rs.getString("productname"));
			productinfobeans.setcost(rs.getInt("cost"));
			productinfobeans.setcolour(rs.getString("colour"));
			productinfobeans.setnumofproduct(rs.getInt("mobile"));
			productinfobeans.setdesc(rs.getString("desc"));
		}
	} catch (Exception e) {
	}
	finally {
		//CLOSE JDBC OBJECTS
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}//end of finally
	return productinfobeans;
}
}

	

