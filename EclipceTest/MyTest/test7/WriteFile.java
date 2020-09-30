package test7;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteFile {
  public static void main(String[] args) {
    try {
      /**����һ��FileWriter ����*/
      FileWriter fw = new FileWriter("E:\\mytest1.txt");
      /**����һ��BufferedWriter ����*/
      BufferedWriter bw = new BufferedWriter(fw);
      String n=null;
      System.out.println("Please enter a word in the txt:");
      Scanner s=new Scanner(System.in);
      n=s.nextLine();
      //ע���ж������á�.equals��
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