package event.feedback;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnect {

	//Encapsulation
	private static String url = "jdbc:mysql://localhost:3306/event";
	private static String user = "root";
	private static String password = "IT21257018";
	private static Connection con;
	
	public static Connection getConnection() {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,user,password);
			
		}
		catch(Exception e){
			System.out.println("Connection is not successful");
		}
		
		return con;
	}
	
	
}
