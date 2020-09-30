package ConferenceManagementSystem;

import java.sql.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DBTool {
	
	private static Connection conn;
	private static Statement stat;
    private static ResultSet result;
    public static int i=0;
    public static String data[][];
    
	public static boolean queryAdmin(String aName,String aPassword){
		boolean result=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException ce) {
			ce.printStackTrace();
		}
		
		try {
			String url="jdbc:mysql://localhost:3306/liu7?user=Liu7&password=Liu7";
		    conn=(Connection) DriverManager.getConnection(url);    
		    PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("SELECT * from adminsql where adminName=? and adminPassword=?");
		    pstmt.setString(1, aName);
			pstmt.setString(2, aPassword);
			ResultSet set=pstmt.executeQuery();	
		    if(set.next()) {
				result=true;
				}
		    if(conn!=null){
				conn.close();
			}
			}catch(SQLException se) {
				se.printStackTrace();
			}
		return result;
		}
	
	
	public static boolean queryTeacher(String tName,String tPassword){
		boolean result=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException ce) {
			ce.printStackTrace();
		}
		
		try {
			String url="jdbc:mysql://localhost:3306/liu7?user=Liu7&password=Liu7";
		    conn=(Connection) DriverManager.getConnection(url);    
		    PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("SELECT * from teachersql where TName=? and TPassword=?");
		    pstmt.setString(1, tName);
			pstmt.setString(2, tPassword);
			ResultSet set=pstmt.executeQuery();	
		    if(set.next()) {
				result=true;
				}
		    if(conn!=null){
				conn.close();
			}
			}catch(SQLException se) {
				se.printStackTrace();
			}
		return result;
		
	}
	
	public static void queryMeeting(String s) throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			}
		
	try {
		String url="jdbc:mysql://localhost:3306/liu7?user=Liu7&password=Liu7";
		conn=(Connection) DriverManager.getConnection(url);
		Statement stmt=conn.createStatement();
		ResultSet set=stmt.executeQuery("SELECT count(*)from meetingsql");	
	    if(set.next()) {	
    		i=set.getInt(1);
    	}
	    }catch(SQLException se) {
	    	se.printStackTrace();
	    	}
	     data=new String[i][6];
	      stat=conn.createStatement();
	    result=stat.executeQuery("SELECT *from meetingsql");
	    int y=0;
	    while(result.next()) {
	    		for(int z=0;z<6;z++) {
	    			data[y][z]=result.getNString(z+1);
	    		}
	    		y++;
	    	}
	    }

	public static void insertMeeting(String mId,String mName,String mHoster,String mAdress,String mDate,String mMember) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException ce) {
			ce.printStackTrace();
		}
		
		try {
			String url="jdbc:mysql://localhost:3306/liu7?user=Liu7&password=Liu7";
			conn=(Connection) DriverManager.getConnection(url);
			stat=conn.createStatement();
			stat.executeUpdate("INSERT into meetingsql (MId,MName,MHoster,MAdress,MDate,MMember)VALUES('"+mId+"','"+mName+"','"+mHoster+"','"+mAdress+"','"+mDate+"','"+mMember+"')");		
		}catch(SQLException se) {
			se.printStackTrace();
		}
	}
	
	
	public static void deleteMeeting(String id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			}catch(ClassNotFoundException ce) {
				ce.printStackTrace();
				}
		
		try {
			String url="jdbc:mysql://localhost:3306/liu7?user=Liu7&password=Liu7";
			conn=(Connection) DriverManager.getConnection(url);
			stat=conn.createStatement();
			stat.executeUpdate("delete from meetingsql where MId='"+id+"'");
		}catch(SQLException se) {
			se.printStackTrace();
		}
		
	}
	
	
	public static void findMeeting(String n) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			}catch(ClassNotFoundException ce) {
				ce.printStackTrace();
				}
		
		
		try {
			String url="jdbc:mysql://localhost:3306/liu7?user=Liu7&password=Liu7";
			conn=(Connection) DriverManager.getConnection(url);
			stat=conn.createStatement();
			stat.executeUpdate("delete from meetingsql where MId='"+n+"'");
			
			
		}catch(SQLException se) {
			se.printStackTrace();
		}
			
	}
	
	
	public static void interTeacher(String ti,String tn,String tp){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException ce) {
			ce.printStackTrace();
		}
		
		try {
			String url="jdbc:mysql://localhost:3306/liu7?user=Liu7&password=Liu7";
			conn=(Connection) DriverManager.getConnection(url);
			stat=conn.createStatement();
			stat.executeUpdate("INSERT into teachersql (TId,TName,TPassword)VALUES('"+ti+"','"+tn+"','"+tp+"')");		
		}catch(SQLException se) {
			se.printStackTrace();
		}
	}
	
	
	
	public static boolean checkTeacherI(String id) {
		boolean result=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException ce) {
			ce.printStackTrace();
		}
		
		try {
			String url="jdbc:mysql://localhost:3306/liu7?user=Liu7&password=Liu7";
		    conn=(Connection) DriverManager.getConnection(url);    
		    PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("SELECT * from teachersql where TId=?");
		    pstmt.setString(1, id);
			ResultSet set=pstmt.executeQuery();	
		    if(set.next()) {
				result=true;
				}
		    if(conn!=null){
				conn.close();
			}
			}catch(SQLException se) {
				se.printStackTrace();
			}
		return result;
	}
	

	public static boolean checkMeeting(String id) {
		boolean result=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException ce) {
			ce.printStackTrace();
		}
		
		try {
			String url="jdbc:mysql://localhost:3306/liu7?user=Liu7&password=Liu7";
		    conn=(Connection) DriverManager.getConnection(url);    
		    PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("SELECT * from meetingsql where MId=?");
		    pstmt.setString(1, id);
			ResultSet set=pstmt.executeQuery();	
		    if(set.next()) {
				result=true;
				}
		    if(conn!=null){
				conn.close();
			}
			}catch(SQLException se) {
				se.printStackTrace();
			}
		return result;
	}
	
	
	public static ResultSet QueryMeeting(String id) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException ce) {
			ce.printStackTrace();
		}
		
		ResultSet set=null;
		try {
			String url="jdbc:mysql://localhost:3306/liu7?user=Liu7&password=Liu7";
		    conn=(Connection) DriverManager.getConnection(url);   
		    PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("SELECT * from meetingsql where MId=?");
		    pstmt.setString(1, id);
			set=pstmt.executeQuery();		
		
	}catch(Exception e1) {
		e1.printStackTrace();
	}
		return set;
	
	}
	
	public static void changeMeeting(String mId,String mName,String mHoster,String mAdress,String mDate,String mMember) {
		String id=mId;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException ce) {
			ce.printStackTrace();
		}
		
		String url="jdbc:mysql://localhost:3306/liu7?user=Liu7&password=Liu7";
		try {
			conn=(Connection) DriverManager.getConnection(url);
			stat=conn.createStatement();
			stat.executeUpdate("update meetingsql set MId='"+mId+"',MName='"+mName+"', MHoster='"+mHoster+"',MAdress='"+mAdress+"', MDate='"+mDate+"',MMember='"+mMember+"'"
					+ "where MId='"+id+"'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
}