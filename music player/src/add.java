import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class add {
	Scanner sc1= new Scanner(System.in);
	Connection con =null;
	Statement stmt =null;
	PreparedStatement pstmt =null;
	ResultSet rs=null;
	add(){
		System.out.println("Enter song id");
		int id =sc1.nextInt();
		System.out.println("Enter song title");
		String title = sc1.next();
		System.out.println("Enter artist name");
		String artist = sc1.next();
		System.out.println("Enter album name");
		String album = sc1.next();
		System.out.println("Enter song location ");
		String location = sc1.next();
		System.out.println("Enter descrption");
		String desc = sc1.next();
	
		

			try {
				Class.forName("com.mysql.jdbc.Driver");
				con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer?user=root&password=root"); 
				String query= "insert into MusicFiles values(?,?,?,?,?,?)";
				pstmt = (PreparedStatement) con.prepareStatement(query);
				pstmt.setInt(1,id);
				pstmt.setString(2,title);
				pstmt.setString(3,artist);
				pstmt.setString(4,album);
				pstmt.setString(5,location);
				pstmt.setString(6,desc);
				
				
				int n1 = pstmt.executeUpdate();
				
				if(n1>0) {
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
	

