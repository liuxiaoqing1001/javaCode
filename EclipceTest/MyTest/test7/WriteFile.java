package test7;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteFile {
  public static void main(String[] args) {
    try {
      /**创建一个FileWriter 对象*/
      FileWriter fw = new FileWriter("E:\\mytest1.txt");
      /**创建一个BufferedWriter 对象*/
      BufferedWriter bw = new BufferedWriter(fw);
      String n=null;
      System.out.println("Please enter a word in the txt:");
      Scanner s=new Scanner(System.in);
      n=s.nextLine();
      //注：判断内容用“.equals”
      while(!n.equalsIgnoreCase("over")) {
    	  bw.write(n);
    	  bw.newLine();
    	  n=s.nextLine();
      }
      //bw.write("first");
      //bw.write("second");
     
      //bw.write("last");
      bw.flush();
      fw.close();
    }
    catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
}