import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class update {
	Scanner sc= new Scanner(System.in);
	Connection con =null;
	Statement stmt =null;
	PreparedStatement pstmt =null;
	ResultSet rs=null;
	update(){
		System.out.println("Enter song_title where u need to be change");
		String title =sc.next();
		System.out.println("Enter name of artist");
		String name =sc.next();

		try {                               
			Class.forName("com.mysql.jdbc.Driver");
			con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer?user=root&password=root"); 
			String query= "update MusicFiles set artist_name=? where song_title=? ";
			pstmt = (PreparedStatement) con.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, title);
		
			
			int n4 = pstmt.executeUpdate();
			
			if(n4>0) {
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
