import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class delete {
	Scanner sc= new Scanner(System.in);
	Connection con =null;
	Statement stmt =null;
	PreparedStatement pstmt =null;
	ResultSet rs=null;
	delete(){
		System.out.println("Enter title where u need to be delete");
		String title =sc.next();
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer?user=root&password=root"); 
				String query= "delete from MusicFiles where song_title = ?";
					pstmt = (PreparedStatement) con.prepareStatement(query);
					pstmt.setString(1, title);
				int n2= pstmt.executeUpdate();
				if(n2>0) {
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
