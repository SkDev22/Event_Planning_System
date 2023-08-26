package event.feedback;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class feedbackDB {
	
	//declare variables
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static  ResultSet rs = null;
	
	//--------------- Retrieve part --------------------
	public static List<feedback> validate(String name, String email){
		
		ArrayList<feedback> feed = new ArrayList<>();
		
		//validate details
		try {
			con = DbConnect.getConnection(); //connect to the DbConnect.java page
			stmt = con.createStatement();
			String sql = "select * from feedback where name='"+name+"' and email='"+email+"'";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				int id = rs.getInt(1);
				String uname = rs.getString(2);
				String uemail = rs.getString(3);
				String message = rs.getString(4);
				
				feedback f = new feedback(id,uname,uemail,message);
				
				feed.add(f);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return feed;
		
	}
	
	
    //--------------- Insert part --------------------
	public static boolean insertfeedback(String name,String email,String message) {
		
		boolean isSuccess = false;
		
		
		try {
			con = DbConnect.getConnection();
			stmt = con.createStatement();
			String sql = "insert into feedback values(0,'"+name+"','"+email+"','"+message+"')";
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return isSuccess;
		
	}
	
	//--------------- Update part --------------------
		
	public static boolean updatefeedback(String id, String name, String email, String message) {
		try {
			con = DbConnect.getConnection();
			stmt = con.createStatement();
			String sql = "update feedback set name='"+name+"',email='"+email+"',message='"+message+"'"+"where id='"+id+"'";
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			}
			else {
				isSuccess =  false;
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	
	
	public static List<feedback> getfeedbackDetails(String Id) {
    	
    	int convertedID = Integer.parseInt(Id);
    	
    	ArrayList<feedback> feed = new ArrayList<>();
    	
    	try {
    		
    		con = DbConnect.getConnection();
    		stmt = con.createStatement();
    		String sql = "select * from customer where id='"+convertedID+"'";
    		rs = stmt.executeQuery(sql);
    		
    		while(rs.next()) {
    			int id = rs.getInt(1);
    			String name = rs.getString(2);
    			String email = rs.getString(3);
    			String message = rs.getString(4);
    			
    			feedback f = new feedback(id,name,email,message);
    			feed.add(f);
    		}
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}	
    	return feed;	
    }
	

	//--------------- Delete part --------------------
	public static boolean deletefeedback(String id) {
		
		int convId = Integer.parseInt(id);
		
		try {
			con = DbConnect.getConnection();
			stmt = con.createStatement();
			String sql = "delete from feedback where id='"+convId+"'";
			int r = stmt.executeUpdate(sql);
			
			if(r > 0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		return isSuccess;
	}
	

}
