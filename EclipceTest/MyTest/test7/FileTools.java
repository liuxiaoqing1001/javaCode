package test7;
import java.io.*;
import java.util.*;
@SuppressWarnings("unused")
public class FileTools {
	public static void main(String[] args){
		write();
		String sourceFileName="E:\\mytest1.txt";
		String objectFileName="E:\\456.txt";
		FileTools.copyFile(sourceFileName,objectFileName);
	}
	
	public static void write() {
		    try {
		      /**创建一个FileWriter 对象*/
		      FileWriter fw = new FileWriter("E:\\mytest1.txt");
		      /**创建一个BufferedWriter 对象*/
		      BufferedWriter bw = new BufferedWriter(fw);
		      String n=null;
		      System.out.println("Please enter a word in the txt:");
		      @SuppressWarnings("resource")
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
	
	public static String read(String fileName){
		    //add your code here 
			String result=null;
			try {
				//创建一个FileReader对象.
			      FileReader fr = new FileReader(fileName);
			      //创建一个BufferedReader 对象.
			      BufferedReader br = new BufferedReader(fr);
			      //读取一行数据.
			      String line = br.readLine();
			      while (line != null) {
			        result+=line;
			        line = br.readLine();
			      }
			      br.close();
			      fr.close();
			    }
			    catch (IOException ioe) {
			      ioe.printStackTrace();
			    }
			return result;
		}
	
		public static void copyFile(String sourceFileName,String objectFileName) {
			
			String s=read(sourceFileName);
		    try {
		    	
		      //创建一个FileReader对象.
		      FileReader fr = new FileReader(sourceFileName);
		      //创建一个BufferedReader 对象.
		      BufferedReader br = new BufferedReader(fr);
		      //创建一个FileWriter 对象
		      FileWriter fw = new FileWriter(objectFileName);
		      //创建一个BufferedWriter 对象
		      BufferedWriter bw = new BufferedWriter(fw);
		      //读取一行数据.
		      
		      String line = br.readLine();
		      while (line != null) {
		    	  bw.write(line);
		    	  bw.newLine();
		    	  line = br.readLine();
		      }
		      br.close();
		      fr.close();
		      
		      bw.flush();
		      fw.close();
		    }
		    catch (IOException ioe) {
		      ioe.printStackTrace();
		    }
		
	}
}