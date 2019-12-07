package com.manthan.hotelapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Showallfooditems {
	Connection con =null;
	Statement stmt =null;
	ResultSet rs=null;
	Showallfooditems(){
	try {
		Driver d=new Driver();
		DriverManager.registerDriver(d);
		con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel_Db?user=root&password=root"); 
		stmt = con.createStatement();
		rs = stmt.executeQuery("select * from Hotel_Bill");
		System.out.println(" Item Code " + " Item Name "+ " Price ");
		while(rs.next()) 
		{
			int Itemcode=rs.getInt("Item_code");
			String FoodName=rs.getString("Food_Name");
			double price= rs.getDouble("Price");
			System.out.println(" "+Itemcode+"	    "+FoodName+"	 "+price);	
		}
	}catch(Exception e) {
		e.printStackTrace();
		
	}
	finally
	{
		try
		{
			if(rs!=null)
				rs.close();
			if(stmt!=null)
				stmt.close();
			if(con!=null)
				con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
}


