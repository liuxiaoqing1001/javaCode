package test11;
import java.io.*;
import java.sql.*;
//import java.util.Properties;
import java.util.*;

public class JdbcTest {
  private Properties props;
  private String url;
  private String user;
  private String passwd;

  public JdbcTest() {
    testJdbc();
    try {
      jbInit();
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public static void main(String[] args) {
    JdbcTest jdbctest = new JdbcTest();
  }

  public void testJdbc() {
    try {
      props = new Properties();
      props.load(new FileInputStream("jdbc.properties"));
      url = props.getProperty("url");
      user = props.getProperty("user");
      passwd = props.getProperty("password");
      Class.forName(props.getProperty("driver"));
      Connection conn=DriverManager.getConnection(url, user, passwd);
      Statement stmt = conn.createStatement();
      ResultSet result = stmt.executeQuery("SELECT * FROM authors");
      while (result.next()) {
        System.out.println("\n----------------------------------------------------");
        System.out.print(result.getString("au_fname")+"\t");
        System.out.print(result.getString("city") + "\t");
        System.out.print(result.getString("address") + "\t");
      }
      System.out.println();
      stmt.executeUpdate("update authors set state='cn' where au_id='172-32-1176';");
      stmt.executeUpdate("insert into authors(au_id,au_lname,au_fname,contract) values('123-45-6789','hello','good',0);");
      stmt.executeUpdate("insert into authors(au_id,au_lname,au_fname,contract) values('000-00-0000','hello','good',0);");
      stmt.executeUpdate("delete from authors where au_id='123-45-6789';");
      result = stmt.executeQuery("SELECT * FROM authors where au_id='000-00-0000'");
      if (result.next()) {
        System.out.println("\n----------------------------------------------------");
        System.out.print(result.getString("au_fname")+"\t");
        System.out.print(result.getString("city") + "\t");
        System.out.print(result.getString("address") + "\t");
      }
      System.out.println();
      stmt.close();
      conn.close();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void jbInit() throws Exception {
  }
}