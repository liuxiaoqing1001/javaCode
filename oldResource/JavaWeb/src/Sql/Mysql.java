package Sql;

import java.sql.*;
import java.util.Scanner;

public class Mysql {
    static final String DB_URL = "jdbc:mysql://localhost:3306/person";
    static final String USER = "root";
    static final String PASS = "123456";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            stmt = conn.createStatement();
//           System.out.println("Please enter your operational statement.");
//           Scanner s=new Scanner(System.in);
            String sql = "SELECT * FROM student";
//           String sql=s.nextLine();
            ResultSet rs = stmt.executeQuery(sql);
            rs.beforeFirst();
            System.out.println("The operating result:");
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String pwd = rs.getString("pass");
                System.out.println("ID: " + id+", name: " + name+", pass: " + pwd);
            }
            conn.commit();
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            se.printStackTrace();
            try{
                if(conn!=null)
                    conn.rollback();
            }catch(SQLException se2){
                se2.printStackTrace();
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){

            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
}