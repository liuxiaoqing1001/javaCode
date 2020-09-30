package test12;

//import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Adsd {


		// TODO Auto-generated method stub
		public static void main(String [] args) {
		    try {
		        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		    }catch (ClassNotFoundException ce) {
		        System.out.println(ce);
		    } 
		    try {
				String url = "jdbc:odbc:test";
				Connection con = DriverManager.getConnection(url);
				java.sql.Statement stmt = con.createStatement();
				ResultSet result =stmt.executeQuery("SELECT * FROM table1");
				while(result.next()) {
				    System.out.print(result.getInt("id") + "\t");
				    System.out.print(result.getString("name") + "\t");
				    System.out.print(result.getString("email") + "\t");
				}
						result.close();
						stmt.close();
						con.close();
				    }catch (SQLException e) {
				        System.out.println(e);
				    }
				}
}