package com.manthan.hotelapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;

public class Takeordersfromcustomer {

	public double takeorders() {
		int foodchoice = 1;
		double billofcustomer=0;
		List<Double> bill_of_eachitem = new ArrayList<Double>();
		PreparedStatement pstmt =null;
		Connection con =null;
		ResultSet rs=null;
		Scanner scanner= new Scanner(System.in);
			while(foodchoice!=0) 
			{
				System.out.println("Enter the food codes to order");
				System.out.println("Press 0 to exit");
				foodchoice = scanner.nextInt();
				try {
					Driver d=new Driver();
					DriverManager.registerDriver(d);
					con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel_Db?user=root&password=root"); 
					String query= "select * from Hotel_Bill where Item_code=?";
					pstmt = (PreparedStatement) con.prepareStatement(query);
					pstmt.setInt(1,foodchoice);
					rs = pstmt.executeQuery();
					if(rs.next())
					{		
						bill_of_eachitem.add(rs.getDouble("Price"));
					}else 
					{
						System.out.println("Iteam not present");
					}
	
				} catch(Exception e)
				{
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
					catch(Exception e) 
					{
						e.printStackTrace();
					}
					}			
			}
			for(int i = 0; i < bill_of_eachitem.size(); i++)
				billofcustomer += bill_of_eachitem.get(i);
		return billofcustomer;
	}
}
