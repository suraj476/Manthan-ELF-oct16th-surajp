import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.mysql.jdbc.PreparedStatement;

public class play {
	
	
	List<String> all = new ArrayList<String>();

		
   
		public void allsongs() {
			
			Connection con =null;
			Statement stmt =null;
			PreparedStatement pstmt =null;
			ResultSet rs=null;
			List<String> all = new ArrayList<String>();
			
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con= DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer?user=root&password=root"); 
				stmt = con.createStatement();
				rs = stmt.executeQuery("select * from MusicFiles");
					while(rs.next()) {
					int id=rs.getInt("song_id");
					String title=rs.getString("song_title");
				all.add(title);
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
			
		for(Object r: all) {
			System.out.println(r);
		}
		
		}
  public void allsongsrandomly() {
		Connection con =null;
		Statement stmt =null;
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		List<String> all = new ArrayList<String>();
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer?user=root&password=root"); 
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from MusicFiles");
				while(rs.next()) {
				int id=rs.getInt("song_id");
				String title=rs.getString("song_title");
			all.add(title);
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
	  
	  
	  Collections.shuffle(all); 
		for(Object r: all) {
			System.out.println(r);
		}
	
}
  public void singlesong() {
	  PreparedStatement stmt =null;
		Connection con =null;
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
			con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
}
	
	
	
	

