package com.manthan.hotelapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class Modifyfooditem {
	
	Scanner sc= new Scanner(System.in);
	Connection con =null;
	Statement stmt =null;
	PreparedStatement pstmt =null;
	ResultSet rs=null;
	 Modifyfooditem(){
		System.out.println("Enter Item_code where u need to be change");
		int itemcode =sc.nextInt();
		System.out.println("Enter food name");
		String name =sc.next();
		System.out.println("Enter price of the food");
		Double price =sc.nextDouble();
		try {                               
			Class.forName("com.mysql.jdbc.Driver");
			con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel_Db?user=root&password=root"); 
			String query= "update Hotel_Bill set Food_Name=?,price=? where Item_code=?";
			pstmt = (PreparedStatement) con.prepareStatement(query);
			pstmt.setString(1,name);
			pstmt.setDouble(2, price);
			pstmt.setInt(3, itemcode);
			int n = pstmt.executeUpdate();
			if(n>0) {
				System.out.println("Record updated succsessfully....");
			}else {
				System.out.println("update  failed");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(rs!=null)
					rs.close();
				if(pstmt!=null)
					pstmt.close();
				if(con!=null)
					con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
