package com.manthan.hotelapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class DeletefoodItem {

	Scanner sc= new Scanner(System.in);
	Connection con =null;
	Statement stmt =null;
	PreparedStatement pstmt =null;
	ResultSet rs=null;
	public DeletefoodItem()
	{
		System.out.println("Enter item code where u need to be delete");
		int itemcode =sc.nextInt();
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel_Db?user=root&password=root"); 
					String query= "delete from Hotel_Bill where Item_code=?";
					pstmt = (PreparedStatement) con.prepareStatement(query);
					pstmt.setInt(1,itemcode);
					int n= pstmt.executeUpdate();
					if(n>0) {
						System.out.println("Record deleted succsessfully....");
					}else {
						System.out.println("update  failed");
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
