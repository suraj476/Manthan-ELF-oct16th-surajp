import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;

public class music_player {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println(" press ");
		System.out.println(" 1. play a song ");
		System.out.println(" 2. search a song ");
		System.out.println(" 3. show all song ");
		System.out.println(" 4. operate on song database");
		int ch =sc.nextInt();
		switch(ch) {
		
		case 1:{System.out.println(" press ");
		System.out.println(" A. play all song ");
		System.out.println(" B. play all songs  randomly ");
		System.out.println(" C. play selected songs ");
		String ch4 =sc.next();
		switch (ch4) {
		case "A":{
			play play = new play();
			play.allsongs();
			break;
		}
		case "B":{
			play play = new play();			
			play.allsongsrandomly();
			break;
		
		}
		case "D":{
			play play = new play();
			play.singlesong();
			break;
		}
		
		
		default:{
			System.out.println("invalid choice");
			break;
		}
		}
		break;
		}
			
			
			
		
			
		
		
		
		case 2: {
			search s1 =new search();
			break;
		
		}
		case 3:{ 
			showallsongs show = new showallsongs();
			
			break;
		
		}
		case 4:{System.out.println(" press ");
		System.out.println(" A. add a song ");
		System.out.println(" B. edit an existing  song ");
		System.out.println(" C. delete an song ");
		String ch3 =sc.next();
		switch (ch3) {
		case "A":{
			add add=new add();
			break;
		}
		case "B":{
			update update = new update();
			
			
			break;
		
		}
		case "D":{
			delete delete = new delete();
			
			break;
		}
		
		
		default:{
			System.out.println("invalid choice");
			break;
		}
		}
		
			break;
		}
		default: {
			System.out.println("invalid choice");
			break;
		}
		
		}

	}
}
//---------------------------------------------------
//String jdbcUrl = "jdbc:mysql://localhost:3306/BORAJI";
//String username = "root";
//String password = "admin";
//String sql = "delete from employee where emp_id=1";
//
//try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password); 
//    Statement stmt = conn.createStatement();) {
//  
//  stmt.executeUpdate(sql);
//  System.out.println("Record deleted successfully");
//} catch (SQLException e) {
//  e.printStackTrace();
//}
//}
//}
//
//System.out.println("Enter name of the song");
//String name =sc.next();

//for(Object r: all) {
//	System.out.println(r);
//}

//try {
//    String url = "jdbc:msql://200.210.220.1:1114/Demo";
//    Connection conn = DriverManager.getConnection(url,"","");
//    Statement stmt = conn.createStatement();
//    ResultSet rs;
//
//    rs = stmt.executeQuery("SELECT Lname FROM Customers WHERE Snum = 2001");
//    while ( rs.next() ) {
//        String lastName = rs.getString("Lname");
//        System.out.println(lastName);
//    }
//    conn.close();
//} catch (Exception e) {
//    System.err.println("Got an exception! ");
//    System.err.println(e.getMessage());
//}



//
//System.out.println("song_id = "+id);				
//System.out.println("song_title =  "+title);
//System.out.println("artist_name =  "+artist);
//System.out.println("album_name =  "+album);
//System.out.println("song_location =  "+location);
//System.out.println("description =  "+desc);
	


