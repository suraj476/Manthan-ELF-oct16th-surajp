import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

public class showallsongs {

	public showallsongs() {
		
		Connection con =null;
		Statement stmt =null;
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		List<Integer> allid = new ArrayList<Integer>();
		List<String> alltitle = new ArrayList<String>();
		List<String> allartist = new ArrayList<String>();
		List<String> allalbum = new ArrayList<String>();
		List<String> alllocation = new ArrayList<String>();
		List<String> alldesc = new ArrayList<String>();
		//select------------------------------------------
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer?user=root&password=root"); 
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from MusicFiles");
			
			while(rs.next()) {
				int id=rs.getInt("song_id");
				String title=rs.getString("song_title");
//				all.add(title);
				String artist=rs.getString("artist_name");
				String album=rs.getString("album_name");
				String location=rs.getString("song_location");
				String desc=rs.getString("description");
				
				System.out.println(""+id+"			"+title+"			"+artist+"			"+album+"		"+location+"		"+desc);				

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
