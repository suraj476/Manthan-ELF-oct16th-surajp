import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class search {
	
	
			
	PreparedStatement stmt =null;
			Connection con =null;
			ResultSet rs=null;
			search(){
				try{
					Class.forName("com.mysql.jdbc.Driver");
				con= DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer?user=root&password=root"); 
				
					Scanner sc1= new Scanner(System.in);

					

					System.out.print("Enter song title:");
					String eid=sc1.next();

					String q= "select * form MusicFiles where song_title=? " ;
					((PreparedStatement) stmt).setString(1, eid);
					stmt = (PreparedStatement) con.prepareStatement(q);
					ResultSet rs1=stmt.executeQuery(q);

					if(rs1.next())
					{
						System.out.println(rs1.getString(1)+","+rs1.getString(2)+","+rs1.getString(3)+","+rs1.getString(4)+","+rs1.getString(5));
					}
					else
					{
						System.out.println("Record Not Found...");
					}
					
				}
				catch(Exception e){
					System.out.println(e);
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

	
		



//	Scanner sc1= new Scanner(System.in);
//	Connection con =null;
//	Statement stmt =null;
//	PreparedStatement pstmt =null;
//	ResultSet rs=null;
//	 search() {
//
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer?user=root&password=root"); 
//			stmt = con.createStatement();
//			System.out.println("Enter song title");
//			String id1 =sc1.next();
//			String query= "select * form MusicFiles where song_title=? " ;
//			pstmt = (PreparedStatement) con.prepareStatement(query);
//			pstmt.setString(1, id1);
//			rs=pstmt.executeQuery(query);
//			while(rs.next()) {
//				int id=rs.getInt("song_id");
//				String title=rs.getString("song_title");
//				String artist=rs.getString("artist_name");
//				String album=rs.getString("album_name");
//				String location=rs.getString("song_location");
//				String desc=rs.getString("description");
//				
//				System.out.println(""+id+"			"+title+"			"+artist+"			"+album+"		"+location+"		"+desc);				
//
//				}
//			
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//			
//		}
//		
//		finally
//		{
//			try
//			{
//				if(rs!=null)
//					rs.close();
//				if(pstmt!=null)
//					pstmt.close();
//				if(con!=null)
//					con.close();
//			}
//			catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
	
//	
//	
//	}
//}
