package com.manthan.hotelapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;

public class Addfooditem {
	Scanner sc1= new Scanner(System.in);
	Connection con =null;
	Statement stmt =null;
	PreparedStatement pstmt =null;
	ResultSet rs=null;
	Addfooditem(){
		
		System.out.println("Enter Item Code");
		int code =sc1.nextInt();
		System.out.println("Enter Food_Item");
		String food = sc1.next();
		System.out.println("Enter Price");
		Double price = sc1.nextDouble();
			try {
				Driver d=new Driver();
				DriverManager.registerDriver(d);
				con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel_Db?user=root&password=root"); 
				String query= "insert into Hotel_Bill values(?,?,?)";
				pstmt = (PreparedStatement) con.prepareStatement(query);
				pstmt.setInt(1,code);
				pstmt.setString(2,food);
				pstmt.setDouble(3, price);
				int n = pstmt.executeUpdate();
				if(n>0) {
					System.out.println("Record inserted succsessfully....");
				}else {
					System.out.println("insertion failed");
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
